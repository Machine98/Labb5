package lab5.general.store;

public class Customer {

    private int customerID;
    private double pickTime;
    private double payTime;

    public Customer(int id, StoreState storeState){
        this.pickTime = storeState.getPickTime();
        this.payTime = storeState.getPayTime();
        setCustomerID(id);
    }

    public void setCustomerID(int id){

        this.customerID = id;
    }
    public double getCustomerPickTime() {
        return pickTime;
    }
    public double getCustomerPayTime() {
        return payTime;
    }
    public int getCustomerID(){

        return this.customerID;
    }
}
