package lab5.general;

import lab5.general.store.*;

public class Simulator {

    private State state;
    private EventQueue eventQueue;
    private View view;
    private Event event;

    public Simulator(State state, View view, EventQueue eventQueue) {
        this.state = state;
        this.view = view;
        this.eventQueue = eventQueue;
    }

    public void run() {
        ((StoreView) view).firstPrint();
        while (!eventQueue.isEmpty() && state.simulating) {
            event = eventQueue.getNext();
            event.performEvent();
        }
        ((StoreState) state).setLastEventTime(event.EventTime());
        ((StoreView) view).lastPrint();
    }
}

