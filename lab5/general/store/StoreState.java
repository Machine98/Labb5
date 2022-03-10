package lab5.general.store;

import lab5.ExponentialRandomStream;
import lab5.UniformRandomStream;
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
    int ocupiedregisters = 0;
    private UniformRandomStream PickTime;
    private UniformRandomStream PayTime;

    public StoreState(long seed, int maxCustomers, int registers, double closingTime,
                      double minPickTime, double maxPickTime, double minPayTime,
                      double maxPayTime, double lambda){

        this.maxCustomers = maxCustomers;
        this.registers = registers;
        this.lambda = lambda;
        this.seed = seed;
        this.minPickTime = minPickTime;
        this.maxPickTime = maxPickTime;
        this.minPayTime = minPayTime;
        this.maxPayTime = maxPayTime;
        this.PickTime = new UniformRandomStream(minPickTime, maxPickTime, seed);
        this.PayTime = new UniformRandomStream(minPayTime, maxPayTime, seed);

    }

    }
    public boolean freeRegisters(){
        if(registers > ocupiedregisters){
            return true;
        }
        return false;
    }

    public int getQueueSize() {
        return queue.size();
    }
}
