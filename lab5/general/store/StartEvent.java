package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.View;

/**
 * Represents the start of the simulation
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class StartEvent extends Event {
    private double time;
    private StoreState storeState;
    /**
     * Constructor
     *
     * @param storeState - The stores state that keeps track of all the moving variables
     * @param time - The time that it takes for an event to be run
     * @param eventQueue - The event queue where it will add new events
     */

    public StartEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.time = time;
        this.storeState = storeState;
    }

    /**
     * Performs what happens when the store opens
     */

    @Override
    public void performEvent() {
        time = 0;
        storeState.setEventName("Start");
        double firstArriveTime = time + storeState.ArrivalTime.newArrivalTime();
        storeState.setOpen(true);
        storeState.update();
        eventQueue.addEvent(new ArrivalEvent(storeState, firstArriveTime, eventQueue));
    }
}
