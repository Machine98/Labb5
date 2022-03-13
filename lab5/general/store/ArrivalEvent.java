package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

public class ArrivalEvent extends Event {
    private double time;
    private Customer customerID;
    private StoreState storeState;

    public ArrivalEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
        this.time = time;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");
        customerID = new Customer(storeState.getTotalCustomers(), storeState);
        storeState.currentCustomerID(customerID.getCustomerID());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();

        if (storeState.isOpen()) {
            storeState.addTotalCustomers();
            if (storeState.getCurrentCustomers() == storeState.getMaxCustomers()) {
                storeState.incCustomersTurnedAway();
            } else {
                double newPickTime = time + storeState.getPickTime();
                eventQueue.addEvent(new PickUpEvent(storeState, newPickTime, customerID, eventQueue));
                storeState.incCurrentCustomers();
            }
            double newArrivalTime = time + storeState.getArrivalTime();
            eventQueue.addEvent(new ArrivalEvent(storeState, newArrivalTime, eventQueue));
        }
    }
}
