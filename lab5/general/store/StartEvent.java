package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class StartEvent extends Event {

    private double time;
    private StoreState state;
    private String name = "StartEvent";

    public StartEvent(StoreState state, double time, EventQueue eventQueue){
        super(state, time, eventQueue);
        this.time = time;
        this.state = state;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performEvent() {
        time = 0;
        state.setEventName("Start");
        double firstArriveTime = time + state.ArrivalTime.newArrivalTime();
        state.setOpen(true);
        state.currentEvent(this);
        state.update();
        eventQueue.addEvent(new ArrivalEvent(state, firstArriveTime, eventQueue));
    }

}
