package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class PayAndLeaveEvent extends Event {
    private State state;
    private Customer customerID;
    private StoreState storeState;


    public PayAndLeaveEvent(StoreState storeState, double time, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.eventQueue = eventQueue;
        this.storeState = storeState;
    }

    @Override
    public void performEvent() {
        if(storeState.freeRegisters()){
            storeState.setEventName("Betalning");
            customerID = (Customer) storeState.customerQueue.first();
            storeState.currentCustomerID(customerID.getCustomerID());
            storeState.addPayedCustomers();
            if(storeState.customerQueue.size() > 1 && storeState.getOcupiedregisters() == storeState.getRegisters()){
                storeState.addTotAmQueue();
            }
            storeState.customerQueue.remove();
        }

        storeState.decOcupiedregisters();

        storeState.setTimePassed(super.EventTime());
        storeState.decCurrentCustomers();
        storeState.update();


    }
}
