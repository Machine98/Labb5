package lab5.general.store;

public class Customer {

    private int customerID;
    private double pickTime;

    public Customer(int id){
        this.pickTime = pickUpTime.newPickUpTime();
        setCustomerID(id);
    }

    public void setCustomerID(int id){

        this.customerID = id;
    }
    public double getPickTime() {
        return pickTime;
    }
    public int getCustomerID(){

        return this.customerID;
    }
}
