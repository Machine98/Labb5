package lab5.general.store;

import lab5.ExponentialRandomStream;

/**
 * Represents the part of the program that utilize ExponentialRandomStream to calculate and randomize the arrival time
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class ArrivalTimeCalc {
    private double lambda;
    private long seed;
    private ExponentialRandomStream ArrivalTime;

    /**
     * Constructor
     *
     * @param lambda time divider
     * @param seed the seed that the randomizers use to perform calculations
     */

    public ArrivalTimeCalc(double lambda, long seed) {
        this.lambda = lambda;
        this.seed = seed;
        this.ArrivalTime = new ExponentialRandomStream(lambda, seed);
    }

    /**
     * Makes a double called newArrivalTime
     *
     * @return time it takes for customer to arrive
     *
     */

    public double newArrivalTime() {
        return ArrivalTime.next();
    }
}
