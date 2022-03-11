package lab5.general.store;

import lab5.general.Event;
import lab5.general.EventQueue;
import lab5.general.State;

public class ArrivalEvent extends Event {
    private double time;
    private boolean open;
    private Customer customerID;
    private Event event;
    private NewCustomer newCustomer;
    private StoreState storeState;

    public ArrivalEvent(StoreState state, double time, EventQueue eventQueue) {
        super(state, time, eventQueue);
        this.storeState = state;
    }

    @Override
    public void performEvent() {
        storeState.setEventName("Ankomst");
        storeState.currentCustomerID(customerID);
        time = storeState.ArrivalTime.newArrivalTime();
        if(storeState.getIsOpen()){
            if(storeState.getCurrentCustomers() == storeState.getMaxCustomers()){
                storeState.setCustomersTurnedAway(1);
            }else{
                customerID = new Customer(storeState.getTotalCustomers(), storeState);
                eventQueue.addEvent(new PickUpEvent(storeState, time, customerID, eventQueue));
                storeState.addTotalCustomers();
                eventQueue.addEvent(new ArrivalEvent(storeState, time, eventQueue));
            }
        }
    }
}
