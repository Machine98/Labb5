package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private Customer customerID;
    private StoreState storeState;
    private String name = "ArrivalEvent";

    public ArrivalEvent(StoreState state, double time, EventQueue eventQueue) {
        super(state, time, eventQueue);
        this.storeState = state;
        this.time = time;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");

        customerID = new Customer(storeState.getTotalCustomers(), storeState);

        storeState.currentCustomerID(customerID.getCustomerID());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        if(storeState.customerQueue.size() >= 1) {
            storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        }
        storeState.setTimePassed(super.EventTime());

        storeState.update();


        if(storeState.isOpen()){

            storeState.addTotalCustomers();

            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.incCustomersTurnedAway();
            }else{

                double newPickTime = time + storeState.getPickTime();
                eventQueue.addEvent(new PickUpEvent(storeState, newPickTime, customerID, eventQueue));
                storeState.incCurrentCustomers();
            }
            double newArrivalTime = time + storeState.getArrivalTime();
            eventQueue.addEvent(new ArrivalEvent(storeState, newArrivalTime, eventQueue));
        }

    }
}
