package lab5.general;

import lab5.general.store.StoreState;

import java.util.Observable;

public abstract class State extends Observable {

    public double timePassed;

    public void setSimulating(boolean simulating) {
        this.simulating = simulating;
    }

    protected boolean simulating = true;

    public State() {
        this.timePassed = 0;
    }

    public double getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(double newTime) {
        this.timePassed = newTime;
    }


}
