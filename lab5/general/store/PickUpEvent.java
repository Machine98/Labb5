package lab5.general.store;
import lab5.general.*;

public class PickUpEvent extends Event {
    private StoreState storeState;
    private int customerID;
    private State state;
    private EventQueue eventqueue;

    public PickUpEvent(StoreState storeState, double time, int customerID, EventQueue queue,
                            State state) {

        super(state, time, queue);
        this.customerID = customerID;
        this.eventQueue = queue;
        this.storeState = storeState;
    }

    public void performEvent() {
        if (storeState.freeRegisters()) {
            eventQueue.addEvent(new PayAndLeaveEvent(/*masssa argument*/));
        }

        //tate.setNewTimePassed(Customer.getPickTime(customerID) + state.timePassed);
    }

}
