package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class EndEvent extends Event {
    private StoreState state;
    private String name = "EndEvent" ;

    public EndEvent(StoreState storeState, double time, EventQueue eventQueue){
        super(storeState, time, eventQueue);
        this.state = storeState;
        this.eventQueue = eventQueue;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void performEvent() {
        state.setSimulating(false);
    }
}
