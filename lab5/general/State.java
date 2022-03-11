package lab5.general;

import lab5.general.store.StoreState;

import java.util.Observable;

public abstract class State extends Observable {

    public double timePassed;
    public boolean simulating = true;

    public State() {
        this.timePassed = 0d;
    }

    public double getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(double newTime) {
        this.timePassed = newTime;
    }


}
