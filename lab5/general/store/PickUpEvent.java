package lab5.general.store;
import lab5.general.*;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID;
    private State state;
    private EventQueue eventQueue;

    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue queue,
                            State state) {

        super(storeState, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
    }

    public void performEvent() {

        storeState.incTimeInCQ(super.EventTime() - state.getTimePassed());
        storeState.incUnoccupiedRegTime(super.EventTime() - state.getTimePassed());

        state.setTimePassed(super.EventTime());
        double newTime = state.getTimePassed() + super.EventTime();

        if (storeState.freeRegisters()) {
            eventQueue.addEvent(new PayAndLeaveEvent(storeState, newTime, customerID, eventQueue, state));
            storeState.incOcupiedregisters();
        }
        else {
            storeState.customerQueue.add(customerID);
        }

        //tate.setNewTimePassed(Customer.getPickTime(customerID) + state.timePassed);
    }

}
