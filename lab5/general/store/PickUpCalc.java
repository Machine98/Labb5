package lab5.general.store;

import lab5.UniformRandomStream;

public class PickUpCalc {
    private double minPickTime;
    private double maxPickTIme;
    private long seed;
    private UniformRandomStream pickUpTime;

    public PickUpCalc(double minPickTime, double maxPickTime, long seed){
        this.minPickTime = minPickTime;
        this.maxPickTIme = maxPickTime;
        this.seed = seed;
        this.pickUpTime = new UniformRandomStream(minPickTime, maxPickTime, seed);
    }
    public double newPickUpTime() {

        return pickUpTime.next();
    }

}