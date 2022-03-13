package lab5;

import java.util.Random;


/**
 * Represents a program feature for randomizing time according to simulation conditions
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class UniformRandomStream {


    private Random rand;
    private double lower, width;

    /**
     * Constructor
     *
     * @param lower - minimum paytime
     * @param upper - maximum paytime
     * @param seed  - a seed used to initialize a pseudorandom number generator
     */

    public UniformRandomStream(double lower, double upper, long seed) {
        rand = new Random(seed);
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * Constructor
     *
     * @param lower - minimum paytime
     * @param upper - maximum paytime
     */

    public UniformRandomStream(double lower, double upper) {
        rand = new Random();
        this.lower = lower;
        this.width = upper - lower;
    }

    /**
     * @return A random double between lower and upper
     */

    public double next() {
        return lower + rand.nextDouble() * width;
    }
}

