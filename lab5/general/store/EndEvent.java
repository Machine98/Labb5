package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.View;

/**
 * Represents the end of the simulation
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class EndEvent extends Event {
    private StoreState storeState;
    private double time;

    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     */

    public EndEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
        this.eventQueue = eventQueue;
        this.time = time;
    }

    /**
     * Performs what happens when the simulation ends
     */

    @Override
    public void performEvent() {
        storeState.setEventName("Stop");
        storeState.setTimePassed(time);
        storeState.update();
        storeState.setSimulating(false);
    }
}
