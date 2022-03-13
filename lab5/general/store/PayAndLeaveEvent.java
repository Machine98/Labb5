package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;


public class PayAndLeaveEvent extends Event {
    private Customer customerID, customerInTurn;
    private StoreState storeState;
    private String name = "PayAndLeaveEvent";


    public PayAndLeaveEvent(StoreState storeState, double time, Customer customerID, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.eventQueue = eventQueue;
        this.storeState = storeState;
        this.customerID = customerID;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Betalning");
        storeState.currentCustomerID(customerID.getCustomerID());
        if(storeState.customerQueue.size() < storeState.getRegisters()){
            storeState.decOcupiedregisters();
        }
        storeState.setTimePassed(super.EventTime());
        storeState.addPayedCustomers();
        storeState.decCurrentCustomers();
        storeState.update();
    }
}
