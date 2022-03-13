package lab5.general.store;

import lab5.UniformRandomStream;

/**
 * Represents the part of the program that utilize UniformRandomStream to calculate and randomize the time it
 * takes to pay for goods
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class CashierSpeedCalc {
    private double minPayTime;
    private double maxPayTime;
    private long seed;
    private UniformRandomStream payTime;

    /**
     * Constructor
     *
     * @param minPayTime minimum pickup time for goods
     * @param maxPayTime maximum pickup time for goods
     * @param seed the seed that the randomizers use to perform calculations
     */

    public CashierSpeedCalc(double minPayTime, double maxPayTime, long seed) {
        this.minPayTime = minPayTime;
        this.maxPayTime = maxPayTime;
        this.seed = seed;
        this.payTime = new UniformRandomStream(minPayTime, maxPayTime, seed);
    }

    /**
     * Makes a double called newPayTime
     *
     * @return time it takes for customer to pay
     *
     */

    public double newPayTime() {
        return payTime.next();
    }
}
