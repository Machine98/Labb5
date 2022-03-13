package lab5.general;

import java.util.Observable;

/**
 * Represents the general state of the simulation
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public abstract class State extends Observable {

    public double timePassed;

    /**
     * A setter that sets the condition if the simulation is supposed to be running or not
     *
     * @param simulating - represents a boolean
     */


    public void setSimulating(boolean simulating) {
        this.simulating = simulating;
    }

    protected boolean simulating = true;


    /**
     * Constructor
     *
     * The constructor sets timePassed to zero since it will be altered during runtime
     */

    public State() {
        this.timePassed = 0;
    }

    /**
     *
     * @return the time passed during simulation
     */

    public double getTimePassed() {
        return timePassed;
    }


    /**
     * A setter that updates timePassed according to method parameter
     *
     * @param newTime - the new (actual) time of the simulation
     */

    public void setTimePassed(double newTime) {
        this.timePassed = newTime;
    }
}
