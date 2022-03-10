package lab5.general;

import lab5.general.store.*;

public class Simulator {

    private State state;
    private EventQueue eventQueue;
    private View view;


    public Simulator(State state, View view){
        this.state = state;
        this.view = view;
        this.eventQueue = new EventQueue();
    }

    public void run() {
        StoreView.firstPrint();
        while (state.simulating){
            eventQueue.addEvent(new StartEvent(state));
            while (eventQueue.size()){
                eventQueue.getFirst().getValue() performEvent();
                StoreView.eventPrint();
            }
            break;
        }
        StoreView.lastPrint();
    }
}

