package lab5.general.store;

import lab5.UniformRandomStream;

public class PickuoCalc {
    private double minPickTime;
    private double maxPickTIme;
    private long seed;
    private static UniformRandomStream pickUpTime;
    public PickuoCalc(double minPickTime, double maxPickTime, long seed){
        this.minPickTime = minPickTime;
        this.maxPickTIme = maxPickTime;
        this.seed = seed;
        this.pickUpTime = new UniformRandomStream(minPickTime, maxPickTime, seed);
    }
    public static double newPickUpTime() {

        return pickUpTime.next();
    }

}
