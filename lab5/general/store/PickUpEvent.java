package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

/**
 * Represents a customer picking up what to buy
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID;
    private EventQueue eventQueue;
    private double time;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     * @param customerID - A specific customer id for the current customer
     */
    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.customerID = customerID;
        this.eventQueue = eventQueue;
        this.storeState = storeState;
        this.time = time;
    }

    /**
     * Performs what happens when the customer picks up items
     */

    @Override
    public void performEvent() {
        storeState.setEventName("Plock");
        storeState.setCurrentCustomerID(customerID.getCustomerID());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();

        if (storeState.freeRegisters()) {
            double newPayTime = time + storeState.getPayTime();
            storeState.incOcupiedregisters();
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
        } else {
            storeState.customerQueue.add(customerID);
            storeState.incTotAmQueue();
        }
    }
}
