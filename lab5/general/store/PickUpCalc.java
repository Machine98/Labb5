package lab5.general.store;

import lab5.UniformRandomStream;

/**
 * Represents the part of the program that utilize UniformRandomStream to calculate and randomize pickup time for goods
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */


public class PickUpCalc {
    private double minPickTime;
    private double maxPickTIme;
    private long seed;
    private UniformRandomStream pickUpTime;

    /**
     * Constructor
     *
     * @param minPickTime minimum pickup time for goods
     * @param maxPickTime maximum pickup time for goods
     * @param seed the seed that the randomizers use to perform calculations
     */

    public PickUpCalc(double minPickTime, double maxPickTime, long seed) {
        this.minPickTime = minPickTime;
        this.maxPickTIme = maxPickTime;
        this.seed = seed;
        this.pickUpTime = new UniformRandomStream(minPickTime, maxPickTime, seed);
    }

    /**
     * Makes a double called newPickUpTime
     *
     * @return time it takes for customer to pick up goods
     */

    public double newPickUpTime() {
        return pickUpTime.next();
    }

}
