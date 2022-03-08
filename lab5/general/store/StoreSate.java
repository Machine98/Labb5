package lab5.general.store;

import lab5.general.ExponentialRandomStream;
import lab5.general.UniformedRandomStream;
import lab5.general.State;

public class StoreSate extends State {
    private boolean simulating;

    private double timePassed;
    private double lastEventTime;

    private long seed;
    private double minPickTime;
    private double maxPickTime;
    private double minPayTime;
    private double maxPayTime;
    private double lambda;

    public State(long seed, int maxCustomers, int registers, double closingTime,
                 double minPickTime, double maxPickTime, double minPayTime,
                 double maxPayTime, double lambda){

        simulating = true;

        timePassed = 0;
        lastEventTime = 0;

        storeState = new StoreSate(maxCustomers, registers, closingTime);

    }
}
