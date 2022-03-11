package lab5.general.store;

public class NewCustomer {
    private StoreState storeState;

    public NewCustomer(int customerNum){
        Customer customer = new Customer(customerNum, storeState);

    }
}
