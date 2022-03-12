package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ClosingEvent extends Event {
    private Event event;
    private State state;
    private StoreState storeState;


    public ClosingEvent(StoreState storeState, double time, EventQueue eventQueue){
        super(storeState, time, eventQueue);
        this.storeState = storeState;
    }

    @Override
    public void performEvent() {
        storeState.isOpen(false);
        storeState.setEventName("Stänger");
        storeState.setTimePassed(super.EventTime());
        storeState.update();
    }
}
