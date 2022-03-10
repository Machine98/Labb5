package lab5.general.store;

public class PayAndLeaveEvent {
    private Customer customer;
    private CustomerQueue customerQueue;
    private StoreState storeState;
    private CashierSpeedCalc cashierSpeedCalc;

    public PayAndLeaveEvent() {
        customerQueue.add(customer);
        storeState.queueSize++;
    }

    public void pay() {
        if(storeState.freeRegisters >= 1){
            customerQueue.remove();
            storeState.ocupiedregisters++;
        }
    }
}

