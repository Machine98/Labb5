package lab5.general;

import lab5.general.store.*;

public class Simulator {

    private State state;
    private EventQueue eventQueue;
    private View view;

    public Simulator(State state, View view, EventQueue eventQueue){
        this.state = state;
        this.view = view;
        this.eventQueue = eventQueue;
    }

    public void run() {
        ((StoreView) view).firstPrint();
        while (!eventQueue.isEmpty() && state.simulating){
            Event event = eventQueue.getNext();
            //StoreView.eventPrint();
            event.performEvent();
        }
        ((StoreView) view).lastPrint();
    }
}

