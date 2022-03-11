package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private EventQueue eventQueue;
    private State state;
    private boolean open;
    private StoreState storeState;
    private Customer customerID;
    private Event event;

    public ArrivalEvent(State state, double time, EventQueue eventQueue) {
        super(state, time, eventQueue);

    }

    @Override
    public void performEvent() {
        time = ArrivalTimeCalc.newArrivalTime();
        if(event.getIsOpen()){
            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.setCustomersTurnedAway(1);
            }else{
                eventQueue.addEvent(new PickUpEvent(storeState, time, customerID, eventQueue, state));
            }
        }
    }
}
