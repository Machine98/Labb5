package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class PayAndLeaveEvent extends Event {
    private State state;
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
        return null;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Betalning");
        storeState.currentCustomerID(customerID.getCustomerID());

        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());

        storeState.setTimePassed(super.EventTime());
        double newPayTime = super.EventTime() + storeState.getPayTime();
        storeState.update();

        storeState.decCurrentCustomers();

        if(storeState.customerQueue.size() >= 1) {
            Customer customerInQeuueID = (Customer) storeState.customerQueue.first();

            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
            storeState.customerQueue.remove();
        }
        else {
            storeState.decOcupiedregisters();

        }

        /*if (storeState.freeRegisters()) {
            storeState.setEventName("Betalning");
            customerID = (Customer) storeState.customerQueue.first();
            storeState.currentCustomerID(customerID.getCustomerID());
            storeState.addPayedCustomers();
            storeState.customerQueue.remove();
            storeState.incOcupiedregisters();
        } else {
            storeState.addTotAmQueue();
            storeState.decOcupiedregisters();
            double timeQueued = super.EventTime() - storeState.getTimePassed();
            storeState.incTimeInCQ(timeQueued);
        }
        storeState.setTimePassed(super.EventTime());
        storeState.decCurrentCustomers();

        storeState.update();*/


    }
}
