package lab5.general.store;

import lab5.ExponentialRandomStream;
import lab5.UniformRandomStream;
import lab5.general.State;

public class StoreState extends State {
    private boolean simulating;

    private double timePassed;
    private double lastEventTime;

    private long seed;
    private double minPickTime;
    private double maxPickTime;
    private double minPayTime;
    private double maxPayTime;
    private double lambda;
    private int registers;
    int ocupiedregisters;

    public StoreState(long seed, int maxCustomers, int registers, double closingTime,
                 double minPickTime, double maxPickTime, double minPayTime,
                 double maxPayTime, double lambda){

        simulating = true;

        timePassed = 0;
        lastEventTime = 0;

        storeState = new StoreState(maxCustomers, registers, closingTime);

    }
    public boolean freeRegisters(){
        if(registers > ocupiedregisters){
            return true;
        }
        return false;
    }
}
