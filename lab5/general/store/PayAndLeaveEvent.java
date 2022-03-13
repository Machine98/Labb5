package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

/**
 * Represents a customer paying what they have picked up and leaving
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class PayAndLeaveEvent extends Event {
    private Customer customerID;
    private StoreState storeState;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     * @param customerID - A specific customer id for the current customer
     */

    public PayAndLeaveEvent(StoreState storeState, double time, Customer customerID, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.customerID = customerID;
        this.eventQueue = eventQueue;
        this.storeState = storeState;
    }

    /**
     * Performs what happens when the customer is paying
     */

    @Override
    public void performEvent() {
        storeState.setEventName("Betalning");
        storeState.setCurrentCustomerID(customerID.getCustomerID());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed()); // Increase Time in Queue.
        // Increase Time for occupied Registers.
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();
        storeState.incPayedCustomers();
        storeState.decCurrentCustomers();
        storeState.setSecondToLastEventTime();

        // If there is customers in queue let them pay one by one in order.
        if (storeState.customerQueue.size() >= 1) {
            double newPayTime = super.EventTime() + storeState.getPayTime();
            // Takes the first customer in the queue and lets the customer pay.
            Customer customerInQueueID = (Customer) storeState.customerQueue.first();
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerInQueueID, eventQueue));
            // Removes the first customer in queue.
            storeState.customerQueue.remove();
        } else {
            storeState.decOcupiedregisters();
        }
    }
}
