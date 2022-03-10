package lab5.general.store;

import lab5.UniformRandomStream;

public class PickuoCalc {
    private double minPickTime;
    private double maxPickTIme;
    private int seed;
    private UniformRandomStream pickUpTime;
    public PickUpTimeCalc(double minPickTime, double maxPickTime, int seed){
        this.minPickTime = minPickTime;
        this.maxPickTIme = maxPickTime;
        this.seed = seed;
        this.pickUpTime =
    }
    public double newPickUpTime() {
        return pickUpTime.next();
    }

}
