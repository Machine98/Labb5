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

        if(storeState.isOpen()){
            storeState.setEventName("Ankomst");

            storeState.setTimePassed(super.EventTime());
            double newPickTime = time + storeState.getPickTime();
            double newArrivalTime = time + storeState.getArrivalTime();

            customerID = new Customer(storeState.getTotalCustomers(), storeState);
            eventQueue.addEvent(new ArrivalEvent(storeState, newArrivalTime, eventQueue));
            storeState.currentCustomerID(customerID.getCustomerID());
            storeState.addTotalCustomers();
            storeState.update();
            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.incCustomersTurnedAway();
            }else{

                eventQueue.addEvent(new PickUpEvent(storeState, newPickTime, customerID, eventQueue));
                storeState.incCurrentCustomers();
            }
        }

    }
}
