package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ClosingEvent extends Event {
    private StoreState storeState;
    private String name = "ClosingEvent";
    private double time;


    public ClosingEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
        this.time = time;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performEvent() {
        storeState.isOpen(false);
        storeState.setEventName("Stänger");
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());

        storeState.update();
    }
}
