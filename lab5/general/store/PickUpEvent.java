package lab5.general.store;

import lab5.general.*;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID, customerInTurn;
    private EventQueue eventQueue;

    private double time;
    private String name = "PickUpEvent";

    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue queue) {

        super(storeState, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
        this.time = time;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Plock");
        storeState.currentCustomerID(customerID.getCustomerID());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());
        double newPayTime = time + storeState.getPayTime();

        if (storeState.freeRegisters() && storeState.customerQueue.size() == 0) {
            storeState.incOcupiedregisters();
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
        } else if (storeState.freeRegisters() == false && storeState.customerQueue.size() == 0) {
            storeState.customerQueue.add(customerID);
            customerInTurn = (Customer) storeState.customerQueue.getIndex(0);
            storeState.addTotAmQueue();
            storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
        }else if (storeState.freeRegisters() == false && storeState.customerQueue.size() > storeState.getRegisters()){
            storeState.customerQueue.add(customerID);
            storeState.addTotAmQueue();
            storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
            customerInTurn = (Customer) storeState.customerQueue.getIndex(0);
            storeState.customerQueue.remove();
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerInTurn, eventQueue));

        }

        storeState.setTimePassed(super.EventTime());
        storeState.update();
    }
}
