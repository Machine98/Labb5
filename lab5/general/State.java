package lab5.general;

import lab5.general.store.StoreState;

import java.util.Observable;

public class State extends Observable {

    private double timePassed;
    private boolean simulating = true;

    public State() {
        this.timePassed = 0;
    }

    public void setNewTimePassed(double newTimePassed) {
        this.timePassed = newTimePassed;
    }

    public double getTimePassed() {
        return timePassed;
    }

    public void stopSimulating() {
        simulating = false;
    }

    /*private StoreSate storeState;

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

    }*/


}
