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


public class ExponentialRandomStream {

    private Random rand;
    private double lambda;

    /**
     * Constructor
     *
     * @param lambda - a simulator constant
     * @param seed   - a seed used to initialize a pseudorandom number generator
     */

    public ExponentialRandomStream(double lambda, long seed) {
        rand = new Random(seed);
        this.lambda = lambda;
    }

    /**
     * Constructor
     *
     * @param lambda - a simulator constant
     */

    public ExponentialRandomStream(double lambda) {
        rand = new Random();
        this.lambda = lambda;
    }

    /**
     * @return A random double that is divided with the variable lambda
     */

    public double next() {
        return -Math.log(rand.nextDouble()) / lambda;
    }
}

