package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private EventQueue eventQueue;
    private State state;

    public ArrivalEvent(State state, double time, EventQueue eventQueue) {
        super(state, time, eventQueue);
    }

    @Override
    public void performEvent() {

    }
}
