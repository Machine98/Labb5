package lab5.general.store;

import lab5.ExponentialRandomStream;

public class ArrivalTimeCalc {
    private double lambda;
    private long seed;
    private ExponentialRandomStream ArrivalTime;

    public ArrivalTimeCalc(double lambda, long seed) {
        this.lambda = lambda;
        this.seed = seed;
        this.ArrivalTime = new ExponentialRandomStream(lambda, seed);
    }

    public double newArrivalTime() {
        return ArrivalTime.next();
    }
}
