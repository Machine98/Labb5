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
        eventQueue.addEvent(new StartEvent(state, eventQueue));
        eventQueue.addEvent(new EndEvent(state, eventQueue));
    }


    private void simulating() {

        while (eventQueue.getNext() && state.getRunningValue() == true){
            eventQueue.run();
        }
    }
}

