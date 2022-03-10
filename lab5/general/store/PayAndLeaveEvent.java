package lab5.general.store;

public class PayAndLeaveEvent {
    private Customer customer;
    private CustomerQueue customerQueue;
    private StoreState storeState;
    private CashierSpeedCalc cashierSpeedCalc;

    public PayAndLeaveEvent() {
        customerQueue.add(customer);
    }

    public void pay() {
        if(storeState.freeRegisters()){
            customerQueue.remove();
            storeState.incOcupiedregisters();
        }
    }
}

