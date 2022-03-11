package lab5.general.store;
import lab5.general.*
public class PayAndLeaveEvent extends Event {
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

