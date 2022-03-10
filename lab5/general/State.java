package lab5.general;

import lab5.general.store.StoreState;

import java.util.Observable;

public class State extends Observable {

    private boolean simulating = true;
    public double timeElapsed = 0;
    private double timePassed;

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




}
