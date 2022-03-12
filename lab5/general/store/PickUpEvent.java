package lab5.general.store;
import lab5.general.*;

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

    public void performEvent() {
        storeState.setEventName("Plock");
        storeState.currentCustomerID(customerID);
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());

        storeState.setTimePassed(super.EventTime());
        //time+= storeState.getTimePassed() + super.EventTime();
        double newPayTime = time + storeState.getPayTime();

        storeState.update();
        if (storeState.freeRegisters()) {
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newPayTime, customerID, eventQueue));
            storeState.incOcupiedregisters();
        }
        else {
            storeState.customerQueue.add(customerID);
        }

        //tate.setNewTimePassed(Customer.getPickTime(customerID) + state.timePassed);
    }

}
