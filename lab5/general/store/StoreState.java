package lab5.general.store;

import lab5.general.State;

public class StoreState extends State {
    private boolean open;

    private CustomerQueue queue = new CustomerQueue();
    private String eventName;
    private PickUpCalc PickTime;
    private CashierSpeedCalc PayTime;

    CustomerQueue customerQueue;
    ArrivalTimeCalc ArrivalTime;

    private long seed;

    private double lastEventTime;
    private double minPickTime;
    private double maxPickTime;
    private double minPayTime;
    private double maxPayTime;
    private double lambda;
    private double unoccupiedRegTime;
    private double timeInCQ;
    private double timeQueued;

    private int ocupiedregisters;
    private int registers;
    private int maxCustomers;
    private int totalCustomers;
    private int currentCustomers;
    private int totAmQueue;
    private int payedCustomers;
    private int customersTurnedAway;
    private int currentCustomerID;


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

    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setLastEventTime(double lastEventTime) {
        this.lastEventTime = lastEventTime;
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
        return this.minPickTime;
    }
    public double getMaxPickTime() {
        return this.maxPickTime;
    }

    public double getMinPayTime() {
        return this.minPayTime;
    }
    public double getMaxPayTime() {
        return this.maxPayTime;
    }

    public long getSeed() {
        return this.seed;
    }

    public int getCurrentCustomerID() {
        return currentCustomerID;
    }
    public void setCurrentCustomerID(int customerID) {
        this.currentCustomerID = customerID;
    }

    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getCurrentCustomers() {
        return this.currentCustomers;
    }
    public void incCurrentCustomers() {
        this.currentCustomers++;
    }
    public void decCurrentCustomers() {
        this.currentCustomers--;
    }

    public int getOcupiedregisters() {
        return ocupiedregisters;
    }
    public void incOcupiedregisters() {
        this.ocupiedregisters++;
    }
    public void decOcupiedregisters() {
        this.ocupiedregisters--;
    }

    public void incTotAmQueue() {
        this.totAmQueue++;
    }
    public int getTotAmQueue() {
        return totAmQueue;
    }

    public void incUnoccupiedRegTime(double timeDiff) {
        unoccupiedRegTime += timeDiff * (registers - ocupiedregisters);
    }
    public double getUnoccupiedRegTime() {
        return this.unoccupiedRegTime;
    }

    public void incPayedCustomers() {
        this.payedCustomers++;
    }
    public int getCustomersPayed() {
        return this.payedCustomers;
    }

    public void incTotalCustomers() {
        this.totalCustomers++;
    }
    public int getTotalCustomers() {
        return this.totalCustomers;
    }

    public void incCustomersTurnedAway() {
        this.customersTurnedAway++;
    }
    public int getCustomersTurnedAway() {
        return this.customersTurnedAway;
    }

    public double getTimeQueued() {
        return timeQueued;
    }
    public void incTimeInCQ(double timeDiff) {
        this.timeQueued += (timeDiff * customerQueue.size());
    }

    public void update() {
        setChanged();
        notifyObservers();
    }
}


