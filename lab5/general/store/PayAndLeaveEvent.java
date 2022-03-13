package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;


public class PayAndLeaveEvent extends Event {
    private Customer customerID;
    private StoreState storeState;
    private String name = "PayAndLeaveEvent";


    public PayAndLeaveEvent(StoreState storeState, double time, Customer customerID, EventQueue eventQueue) {
        super(storeState, time, eventQueue);
        this.customerID = customerID;
        this.eventQueue = eventQueue;
        this.storeState = storeState;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Betalning");
        storeState.currentCustomerID(customerID.getCustomerID());
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        storeState.setTimePassed(super.EventTime());
        storeState.update();
        storeState.addPayedCustomers();
        storeState.decCurrentCustomers();

        if(storeState.customerQueue.size() >= 1) {
            double newPayTime = super.EventTime() + storeState.getPayTime();
            Customer customerInQueueID = (Customer) storeState.customerQueue.first();

            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerInQueueID, eventQueue));

            storeState.customerQueue.remove();
        }
        else {
            storeState.decOcupiedregisters();
        }
    }
}
