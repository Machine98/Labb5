package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

public class ClosingEvent extends Event {
    private StoreState storeState;

    public ClosingEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.storeState = storeState;
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
