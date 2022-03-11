package lab5.general.store;
import lab5.general.*;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID;
    private EventQueue eventQueue;

    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue queue) {

        super(storeState, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
    }

    public void performEvent() {
        storeState.setEventName("Plock");
        storeState.currentCustomerID(customerID);
        storeState.incTimeInCQ(super.EventTime() - storeState.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - storeState.getTimePassed());

        storeState.setTimePassed(super.EventTime());
        double newTime = storeState.getTimePassed() + super.EventTime();

        storeState.update();
        if (storeState.freeRegisters()) {
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newTime, customerID, eventQueue));
            storeState.incOcupiedregisters();
        }
        else {
            storeState.customerQueue.add(customerID);
        }

        //tate.setNewTimePassed(Customer.getPickTime(customerID) + state.timePassed);
    }

}
