package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ClosingEvent extends Event {
    private Event event;
    private State state;


    public ClosingEvent(StoreState storeState, double time, EventQueue eventQueue){
        super(storeState, time, eventQueue);
    }

    @Override
    public void performEvent() {
        event.isOpen(false);
    }
}
