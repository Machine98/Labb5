package lab5.general;

import lab5.general.store.*;

/**
 * Represents the programs function of running the simulation, gathering the events stacked in the EventQueue and performing the events and calling the prints
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class Simulator {

    private State state;
    private EventQueue eventQueue;
    private View view;
    private Event event;

    /**
     * Constructor
     *
     * @param state      - the general state of the program
     * @param view       - the view
     * @param eventQueue - the queue of events
     */

    public Simulator(State state, View view, EventQueue eventQueue) {
        this.state = state;
        this.view = view;
        this.eventQueue = eventQueue;
    }

    /**
     * handles performing the events in the queue and calling the prints out of storeview
     */

    public void run() {
        view.firstPrint();
        while (!eventQueue.isEmpty() && state.simulating) {
            event = eventQueue.getNext();
            event.performEvent();
        }
        ((StoreState) state).setLastEventTime(event.EventTime());
        view.lastPrint();
    }

    /**
     * Handles performing the events in the queue without calling any prints.
     */
    public void optRun() {
        while (!eventQueue.isEmpty() && state.simulating) {
            event = eventQueue.getNext();
            event.performEvent();
        }
    }
}

