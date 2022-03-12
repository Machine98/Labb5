package lab5.general.store;

import lab5.general.Event;
import lab5.general.State;

public class StoreState extends State {

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    private boolean open;

    private CustomerQueue queue = new CustomerQueue();
    private String eventName;
    private Event currentEvent;
    private int currentCustomerID;
    private PickUpCalc PickTime;
    private CashierSpeedCalc PayTime;

    private long seed;

    private double timePassed;
    private double lastEventTime;
    private double minPickTime;
    private double maxPickTime;
    private double minPayTime;
    private double maxPayTime;
    private double lambda;
    private double unoccupiedRegTime;
    private double timeInCQ;

    private int ocupiedregisters = 0;
    private int registers;
    private int maxCustomers;
    private int totalCustomers = 0;
    private int currentCustomers = 0;
    private int totAmQueue = 0;
    private int payedCustomers;
    private int customersTurnedAway;
    private int coinMade;

    CustomerQueue customerQueue;
    ArrivalTimeCalc ArrivalTime;



    public StoreState(long seed, int maxCustomers, int registers, double minPickTime, double maxPickTime, double minPayTime,
                      double maxPayTime, double lambda) {

        this.maxCustomers = maxCustomers;
        this.registers = registers;
        this.lambda = lambda;
        this.seed = seed;
        this.minPickTime = minPickTime;
        this.maxPickTime = maxPickTime;
        this.minPayTime = minPayTime;
        this.maxPayTime = maxPayTime;
        this.PickTime = new PickUpCalc(minPickTime, maxPickTime, seed);
        this.PayTime = new CashierSpeedCalc(minPayTime, maxPayTime, seed);
        this.ArrivalTime = new ArrivalTimeCalc(lambda, seed);
        this.customerQueue = new CustomerQueue();
        this.unoccupiedRegTime = 0.0d;
        this.timeInCQ = 0.0;
    }

    public boolean freeRegisters() {
        if (registers > ocupiedregisters) {
            return true;
        }
        return false;
    }

    public void addTotAmQueue(){
        this.totAmQueue++;
    }

    public int getTotAmQueue(){
        return totAmQueue;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public double getArrivalTime() {
        return ArrivalTime.newArrivalTime();
    }

    public double getPickTime() {
        return PickTime.newPickUpTime();
    }

    public double getPayTime() {
        return PayTime.newPayTime();
    }

    public void incOcupiedregisters() {
        this.ocupiedregisters++;
    }

    public void decOcupiedregisters() {
        this.ocupiedregisters--;
    }

    public int getOcupiedregisters(){
        return ocupiedregisters;
    }

    public int getRegisters() {
        return this.registers;
    }

    public int getMaxCustomers() {
        return this.maxCustomers;
    }

    public double getlambda() {
        return this.lambda;
    }

    public double getMinPickTime() {
        return this.maxPickTime;
    }

    public double getMinPayTime() {
        return this.minPayTime;
    }

    public double getMaxPickTime() {
        return this.maxPickTime;
    }

    public double getMaxPayTime() {
        return this.maxPayTime;
    }

    public long getSeed() {
        return this.seed;
    }

    public int getCurrentCustomers() {
        return this.currentCustomers;
    }

    public int getTotalCustomers() {
        return this.totalCustomers;
    }

    public void addTotalCustomers(){
        this.totalCustomers++;
    }

    public void incCurrentCustomers() {
        this.currentCustomers++;
    }

    public void decCurrentCustomers() {
        this.currentCustomers--;
    }

    public int getCustomersPayed() {

        return this.payedCustomers;
    }

    public int getCustomersTurnedAway() {
        return this.customersTurnedAway;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void addPayedCustomers() {
        this.payedCustomers++;
    }

    public void incCustomersTurnedAway() {
        this.customersTurnedAway++;
    }

    public void currentCustomerID(int customerID) {
        this.currentCustomerID = customerID;
    }

    public int getCurrentCustomerID() {
        return currentCustomerID;
    }

    public void currentEvent(Event event) {
        currentEvent = event;
        setChanged();
        notifyObservers();
    }

    public double getUnoccupiedRegTime(){
        return this.unoccupiedRegTime;
    }

    public void incUnoccupiedRegTime(double timeDiff) {
        unoccupiedRegTime += timeDiff * (registers - ocupiedregisters);

    }

    public void incTimeInCQ(double timeDiff) {
        timeInCQ += timeDiff * customerQueue.size();
    }
    public void update(){
        setChanged();
        notifyObservers();
    }
    public void isOpen(Boolean close){
        open = close;
    }

    public int getQueue(){
        return queue.size();
    }

}


