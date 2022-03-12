package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private Customer customerID;
    private StoreState storeState;

    public ArrivalEvent(StoreState state, double time,Customer customerID, EventQueue eventQueue) {
        super(state, time, eventQueue);
        this.storeState = state;
        this.time = time;
        this.customerID = customerID;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");
        //storeState.currentEvent(this);
        storeState.currentCustomerID(customerID.getCustomerID());

        storeState.setTimePassed(super.EventTime());
        double newPickTime = time + storeState.getPickTime();
        //time+= storeState.ArrivalTime.newArrivalTime();
        double newArrivalTime = time + storeState.getArrivalTime();

        storeState.update();

        if(storeState.isOpen()){

            storeState.addTotalCustomers();
            customerID = new Customer(storeState.getTotalCustomers(), storeState);

            eventQueue.addEvent(new ArrivalEvent(storeState, newArrivalTime, customerID, eventQueue));

            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.incCustomersTurnedAway();
            }else{

                eventQueue.addEvent(new PickUpEvent(storeState, newPickTime, customerID, eventQueue));
                storeState.incCurrentCustomers();
            }
        }
    }
}
