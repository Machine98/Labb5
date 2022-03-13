package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

public class EndEvent extends Event {
    private StoreState storeState;

    public EndEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
        this.eventQueue = eventQueue;
    }

    @Override
    public void performEvent() {
        storeState.setSimulating(false);
    }
}
