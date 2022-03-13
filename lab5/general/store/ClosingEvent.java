package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

/**
 * Represents the closing of the store
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class ClosingEvent extends Event {
    private StoreState storeState;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     */

    public ClosingEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
    }

    /**
     * Performs what happens when the store closes
     */

    @Override
    public void performEvent() {
        storeState.setOpen(false);
        storeState.setEventName("Stänger");
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();
        storeState.setSecondToLastEventTime();
    }
}
