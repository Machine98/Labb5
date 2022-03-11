package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class PayAndLeaveEvent extends Event {
    private State state;
    private Customer customerID;
    private CustomerQueue customerQueue;
    private StoreState storeState;


    public PayAndLeaveEvent(StoreState storeState, double time, Customer customerID,
                            EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.customerID = customerID;
        this.eventQueue = eventQueue;
        this.storeState = storeState;
    }

    @Override
    public void performEvent() {
        storeState.addPayedCustomers();
        customerQueue.remove();
        storeState.decOcupiedregisters();
        storeState.
    }
}
