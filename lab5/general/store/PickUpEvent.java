package lab5.general.store;
import lab5.general.*;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private Customer customerID;
    private State state;
    private EventQueue eventQueue;

    public PickUpEvent(StoreState storeState, double time, Customer customerID, EventQueue queue,
                            State state) {

        super(state, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
    }

    public void performEvent() {
        state.setTimePassed(super.EventTime());
        super.EventTime() - state.timePassed;
        double newTime = state.getTimePassed() + super.EventTime();

        storeState.incUnoccupiedRegistersTime();
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
