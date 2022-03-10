package lab5.general.store;

public class Customer {

    private int customerID;
    private double pickTime;
    private double payTime;

    public Customer(int id, PickuoCalc pickUpTime, PayTimeCalc payTime){
        this.pickTime = pickUpTime.newPickUpTime();
        this.payTime = payTime.newPayTime();
        setCustomerID(id);
    }

    public void setCustomerID(int id){

        this.customerID = id;
    }
    public double getPickTime() {
        return pickTime;
    }
    public double getPayTime() {
        return payTime;
    }
    public int getCustomerID(){

        return this.customerID;
    }
}
