package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class EndEvent extends Event {
    private State state;

    public EndEvent(StoreState storeState, double time, EventQueue eventQueue){
        super(storeState, time, eventQueue);
        this.state = state;
        this.eventQueue = eventQueue;
    }

    @Override
    public void performEvent() {
        state.simulating = false;
    }
}
