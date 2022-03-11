package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class StartEvent extends Event {

    private State state;
    private StoreState storeState;
    private double time;

    public StartEvent(State state, double time,EventQueue eventQueue){
        super(state, time, eventQueue);
        this.state = state;
        this.time = time;
    }

    public void performEvent(StoreState state) {
            time = 0;
            state.currentEvent(this);
            new ArrivalEvent(state, "kund1");
        }
    }

}
