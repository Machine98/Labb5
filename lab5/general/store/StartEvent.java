package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class StartEvent extends Event {

    private StoreState state;
    private double time;

    public StartEvent(StoreState state, double time,EventQueue eventQueue){
        super(state, time, eventQueue);
        this.time = time;
    }

    @Override
    public void performEvent() {
        time = 0;
        state.currentEvent(this);
        new ArrivalEvent(state, time, eventQueue);
    }

}
