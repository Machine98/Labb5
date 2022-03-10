package lab5.general.store;

public class Customer {

    private int customerID;

    public Customer(int id){
        setCustomerID(id);
    }

    public void setCustomerID(int id){
        this.customerID = id;
    }

    public int getCustomerID(){
        return this.customerID;
    }
}
