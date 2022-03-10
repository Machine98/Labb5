package lab5.general.store;

public class NewCustomer {
    private int customerNum = 0;

    public NewCustomer(){
        Customer customer = new Customer(customerNum);
        customerNum++;
    }
}
