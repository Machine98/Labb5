package lab5.general.store;

import lab5.general.State;

/**
 * Represents the container of the whole program, this is where all neccessary data is stored
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */


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
    private double timeQueued;
    private double secondToLastEventTime;

    private int ocupiedregisters;
    private int registers;
    private int maxCustomers;
    private int totalCustomers;
    private int currentCustomers;
    private int totAmQueue;
    private int payedCustomers;
    private int customersTurnedAway;
    private int currentCustomerID;

    /**
     * Constructor
     *
     * @param seed         the seed that the randomizers use to perform calculations
     * @param maxCustomers maximum amount of customers allowed in store
     * @param registers    amount of registers working during opening
     * @param minPickTime  minimum amount of time to pick goods
     * @param maxPickTime  maximum amount of time to pick goods
     * @param minPayTime   minimum amount of time to pay for goods
     * @param maxPayTime   maximum amount of time to pay for goods
     * @param lambda       time divider
     */

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
    }

    /**
     * Setter that sets the time passed for each event except for the "Stop" event
     */

    public void setSecondToLastEventTime() {
        if (!(getEventName() == "Stop")) {
            secondToLastEventTime = getTimePassed();
        }
    }

    /**
     * Getter for the arrival time
     *
     * @return double of the time passed when the second to last event is performed
     */

    public double getSecondToLastEventTime() {
        return secondToLastEventTime;
    }


    /**
     * @return if there are registers free
     */

    public boolean freeRegisters() {
        if (registers > ocupiedregisters) {
            return true;
        }
        return false;
    }

    /**
     * @return that the store is open
     */

    public boolean isOpen() {
        return open;
    }

    /**
     * Setter that sets the store to open
     *
     * @param open
     */

    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * Setter that sets lastEventTime
     *
     * @param lastEventTime
     */

    public void setLastEventTime(double lastEventTime) {
        this.lastEventTime = lastEventTime;
    }

    /**
     * Getter for the arrival time
     *
     * @return double of arrival time
     */

    public double getArrivalTime() {
        return ArrivalTime.newArrivalTime();
    }

    /**
     * Getter for the pickup time
     *
     * @return double of pickup time
     */

    public double getPickTime() {
        return PickTime.newPickUpTime();
    }

    /**
     * Getter for pay time
     *
     * @return double pay time
     */

    public double getPayTime() {
        return PayTime.newPayTime();
    }

    /**
     * Getter for registers
     *
     * @return amount of registers
     */

    public int getRegisters() {
        return this.registers;
    }

    /**
     * Getter for maximum amount of customers allowed
     *
     * @return amount of customers allowed
     */

    public int getMaxCustomers() {
        return this.maxCustomers;
    }

    /**
     * Getter for the variable lambda
     *
     * @return lambda
     */

    public double getlambda() {
        return this.lambda;
    }

    /**
     * Getter for minimum pickup time
     *
     * @return minimum pickup time
     */

    public double getMinPickTime() {
        return this.minPickTime;
    }

    /**
     * Getter for maximum pickup time
     *
     * @return maximum pickup time
     */

    public double getMaxPickTime() {
        return this.maxPickTime;
    }

    /**
     * Getter for minimum pay time
     *
     * @return minimum pay time
     */

    public double getMinPayTime() {
        return this.minPayTime;
    }

    /**
     * Getter for maximum pay time
     *
     * @return maximum pay time
     */

    public double getMaxPayTime() {
        return this.maxPayTime;
    }

    /**
     * Getter for seed
     *
     * @return seed
     */

    public long getSeed() {
        return this.seed;
    }

    /**
     * Getter for the customers ID
     *
     * @return currentCustomerID
     */

    public int getCurrentCustomerID() {
        return currentCustomerID;
    }

    /**
     * Setter for the customers ID
     *
     * @param customerID - CustomerId
     */

    public void setCurrentCustomerID(int customerID) {
        this.currentCustomerID = customerID;
    }

    /**
     * Getter for the events name
     *
     * @return eventName
     */

    public String getEventName() {
        return eventName;
    }

    /**
     * Setter for the events name
     *
     * @param eventName
     */

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Getter for the customers currently residing in the store
     *
     * @return currentCustomers
     */

    public int getCurrentCustomers() {
        return this.currentCustomers;
    }

    /**
     * Increase customers in store by 1
     */

    public void incCurrentCustomers() {
        this.currentCustomers++;
    }

    /**
     * Decrease customers in store by 1
     */

    public void decCurrentCustomers() {
        this.currentCustomers--;
    }

    /**
     * Getter for occupied registers
     *
     * @return ocupiedregisters
     */

    public int getOcupiedregisters() {
        return ocupiedregisters;
    }

    /**
     * Increase occupied registers by 1
     */

    public void incOcupiedregisters() {
        this.ocupiedregisters++;
    }

    /**
     * Decrease occupied registers by 1
     */

    public void decOcupiedregisters() {
        this.ocupiedregisters--;
    }

    /**
     * Increase amount in the customer queue by 1
     */

    public void incTotAmQueue() {
        this.totAmQueue++;
    }

    /**
     * Getter for total amount in the customer queue
     *
     * @return totAmQueue
     */

    public int getTotAmQueue() {
        return totAmQueue;
    }

    /**
     * Increase how long at least one register has been unoccupied
     *
     * @param timeDiff
     */

    public void incUnoccupiedRegTime(double timeDiff) {
        unoccupiedRegTime += timeDiff * (registers - ocupiedregisters);
    }

    /**
     * Getter for how long the registers have been unoccupied
     *
     * @return unccupiedRegTime
     */

    public double getUnoccupiedRegTime() {
        return this.unoccupiedRegTime;
    }

    /**
     * Increase for how many customers have purchased something
     */

    public void incPayedCustomers() {
        this.payedCustomers++;
    }

    /**
     * Getter for how many customers have purchased something
     */

    public int getCustomersPayed() {
        return this.payedCustomers;
    }

    /**
     * Increase for total customers that have been in the store since opening
     */

    public void incTotalCustomers() {
        this.totalCustomers++;
    }

    /**
     * Getter for total customers that have been in the store since opening
     *
     * @return totalCustomers
     */

    public int getTotalCustomers() {
        return this.totalCustomers;
    }

    /**
     * Increase for how many customers have been turned away
     */

    public void incCustomersTurnedAway() {
        this.customersTurnedAway++;
    }

    /**
     * Getter for how many customers have been turned away
     *
     * @return customersTurnedAway
     */

    public int getCustomersTurnedAway() {
        return this.customersTurnedAway;
    }

    /**
     * Getter for how long people have stood in the queue
     *
     * @return timeQueued
     */

    public double getTimeQueued() {
        return timeQueued;
    }

    /**
     * Increase for how long people have stood in the queue
     *
     * @param timeDiff
     */

    public void incTimeInCQ(double timeDiff) {
        this.timeQueued += (timeDiff * customerQueue.size());
    }

    /**
     * Notify the observer that changes have been made.
     */

    public void update() {
        setChanged();
        notifyObservers();
    }
}


