package lab5.general.store;

import lab5.general.State;

public class StoreState extends State {
    private boolean simulating;

    private double timePassed;
    private double lastEventTime;

    private CustomerQueue queue;

    private long seed;
    private double minPickTime;
    private double maxPickTime;
    private double minPayTime;
    private double maxPayTime;
    private double lambda;
    private int registers;
    private int maxCustomers;
    private int totalCustomers;
    private int currentCusomers;
    CustomerQueue customerQueue;
    private int ocupiedregisters = 0;
    private PickUpCalc PickTime;
    private CashierSpeedCalc PayTime;
    private ArrivalTimeCalc ArrivalTime;
    private int payedCustomers;
    private int customersTurnedAway;
    private int coinMade;
    private double unoccupiedRegTime;
    private double timeInCQ;
    private String eventName;
    private Customer currentCustomerID;

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
        return this.currentCusomers;
    }

    public int getTotalCustomers() {
        return this.totalCustomers;
    }
    public void addTotalCustomers(){
        this.totalCustomers = totalCustomers + 1;
    }

    public int getCustomersPayed() {

        return this.payedCustomers;
    }

    public int getCustomersTurnedAway() {
        return this.customersTurnedAway;
    }

    public void currentCustomerID(Customer customerID) {
        this.currentCustomerID = customerID;
    }

    public Customer getCurrentCostumerID() {
        return currentCustomerID;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setPayedCustomers(int payedCustomers) {
        this.payedCustomers = payedCustomers;
    }

    public void setCustomersTurnedAway(int customersTurnedAway) {
        this.customersTurnedAway = customersTurnedAway;
    }

    public void currentEvent(StartEvent startEvent) {

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

    public void update() {
        setChanged();
        notifyObservers();
    }
}


