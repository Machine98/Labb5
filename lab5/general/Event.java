package lab5.general;

import lab5.general.store.StoreState;

/**
 * Represents an abstract event that all other events will be built around
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public abstract class Event {

    private double time;
    private StoreState storeState;
    protected EventQueue eventQueue;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     */

    public Event(StoreState storeState, double time, EventQueue eventQueue) {
        this.storeState = storeState;
        this.time = time;
        this.eventQueue = eventQueue;
    }

    /**
     * An abstract method for what the event will perform
     */

    public abstract void performEvent();

    /**
     * Gets the events current time
     *
     * @return - Returns the time
     */

    public double EventTime() {
        return time;
    }
}
