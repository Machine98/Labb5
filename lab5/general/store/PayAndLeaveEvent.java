package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class PayAndLeaveEvent extends Event {
    private State state;
    private Customer customerID;
    private StoreState storeState;
    private String name = "PayAndLeaveEvent";


    public PayAndLeaveEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.eventQueue = eventQueue;
        this.storeState = storeState;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void performEvent() {
        if (storeState.freeRegisters()) {
            storeState.setEventName("Betalning");
            customerID = (Customer) storeState.customerQueue.first();
            storeState.currentCustomerID(customerID.getCustomerID());
            storeState.addPayedCustomers();
            storeState.customerQueue.remove();
            storeState.incOcupiedregisters();
        } else {
            storeState.addTotAmQueue();
            storeState.decOcupiedregisters();
        }
        storeState.setTimePassed(super.EventTime());
        storeState.decCurrentCustomers();
        storeState.update();


    }
}
