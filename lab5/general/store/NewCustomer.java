package lab5.general.store;

public class NewCustomer {
    private int customerNum = 0;
    private StoreState storeState;

    public NewCustomer(){
        Customer customer = new Customer(customerNum, storeState);
        customerNum++;
    }
}
