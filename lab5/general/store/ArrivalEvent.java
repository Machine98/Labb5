package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

/**
 * Represents the arrival of a new customer
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class ArrivalEvent extends Event {
    private double time;
    private Customer customerID;
    private StoreState storeState;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     */

    public ArrivalEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
        this.time = time;
    }

    /**
     * Performs the changes for a customer arriving
     */

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");
        customerID = new Customer(storeState.getTotalCustomers(), storeState);
        storeState.setCurrentCustomerID(customerID.getCustomerID());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();

        if (storeState.isOpen()) {
            storeState.incTotalCustomers();
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
