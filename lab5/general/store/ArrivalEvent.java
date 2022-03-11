package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private Customer customerID;
    private StoreState storeState;

    public ArrivalEvent(StoreState state, double time, EventQueue eventQueue) {
        super(state, time, eventQueue);
        this.storeState = state;
        this.time = time;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");
        storeState.currentEvent(this);
        storeState.currentCustomerID(customerID);
        time+= storeState.ArrivalTime.newArrivalTime();
        if(storeState.isOpen()){
            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.incCustomersTurnedAway();
            }else{
                customerID = new Customer(storeState.getTotalCustomers(), storeState);
                eventQueue.addEvent(new PickUpEvent(storeState, time, customerID, eventQueue));
                storeState.addTotalCustomers();
                eventQueue.addEvent(new ArrivalEvent(storeState, time, eventQueue));
            }
        }
    }
}
