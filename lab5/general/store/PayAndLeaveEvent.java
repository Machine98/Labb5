package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;


public class PayAndLeaveEvent extends Event {
    private Customer customerID, customerInTurn;
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
        storeState.addPayedCustomers();

        storeState.decCurrentCustomers();

        if(storeState.customerQueue.size() >= 1) {
            Customer customerInQeuueID = (Customer) storeState.customerQueue.first();

            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerInQeuueID, eventQueue));

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
