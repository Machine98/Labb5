package lab5.general.store;

import lab5.UniformRandomStream;
import lab5.general.*;

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
    private int ocupiedregisters = 0;
    private PickuoCalc PickTime;
    private UniformRandomStream PayTime;
    private int payedCustomers;
    private int customersTurnedAway;

    public StoreState(long seed, int maxCustomers, int registers, double closingTime,
                      double minPickTime, double maxPickTime, double minPayTime,
                      double maxPayTime) {

        this.registers = registers;
        this.maxCustomers = maxCustomers;
        this.lambda = lambda;
        this.seed = seed;
        this.minPickTime = minPickTime;
        this.maxPickTime = maxPickTime;
        this.minPayTime = minPayTime;
        this.maxPayTime = maxPayTime;
        this.PickTime = new PickuoCalc(minPickTime, maxPickTime, seed);
        this.PayTime = new UniformRandomStream(minPayTime, maxPayTime, seed);
    }

    public boolean freeRegisters() {
        if (registers > ocupiedregisters) {
            return true;
        }
        return false;
    }

    public void incOcupiedregisters() {
        this.ocupiedregisters++;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getRegisters() {
        return this.registers;
    }

    public int getMaxCustomers() {
        return this.payedCustomers;
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

    public int getTotalCustomers() {
        return this.maxCustomers;
    }

    public int getCustomersPayed() {
        return this.payedCustomers;
    }

    public int getCustomersTurnedAway() {
        return this.customersTurnedAway;
    }

}
