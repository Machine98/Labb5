package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ClosingEvent extends Event {
    private StoreState storeState;
    private String name = "ClosingEvent";
    private double time;
    private Customer customer;


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
        storeState.setTimePassed(super.EventTime());
        storeState.update();
        if (storeState.customerQueue.size() > 0) {
            for (int i = 0; i < storeState.customerQueue.size(); i++) {
                double newPayTime = time + storeState.getPayTime();
                customer = (Customer) storeState.customerQueue.getIndex(i);
                eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customer, eventQueue));
            }
        }
    }
}
