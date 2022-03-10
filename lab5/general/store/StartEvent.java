package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class StartEvent extends Event {

    private State state;
    private StoreState storeState;
    private double time;

    public StartEvent(State state){
        super(state, time, eventQueue);
        this.state = state;
        this.time = time;
    }

    public void excuteEvent(){

    }
}
