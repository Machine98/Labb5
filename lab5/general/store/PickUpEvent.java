package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID;
    private EventQueue eventQueue;
    private double time;

    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue queue) {
        super(storeState, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
        this.time = time;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Plock");
        storeState.setCurrentCustomerID(customerID.getCustomerID());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();

        if (storeState.freeRegisters()) {
            double newPayTime = time + storeState.getPayTime();
            storeState.incOcupiedregisters();
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
        } else {
            storeState.customerQueue.add(customerID);
            storeState.incTotAmQueue();
        }
    }
}
