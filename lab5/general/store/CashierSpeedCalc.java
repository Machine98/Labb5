package lab5.general.store;

import lab5.UniformRandomStream;

public class CashierSpeedCalc {
    private double minPayTime;
    private double maxPayTime;
    private long seed;
    private UniformRandomStream payTime;

    public CashierSpeedCalc(double minPayTime, double maxPayTime, long seed) {
        this.minPayTime = minPayTime;
        this.maxPayTime = maxPayTime;
        this.seed = seed;
        this.payTime = new UniformRandomStream(minPayTime, maxPayTime, seed);
    }

    public double newPayTime() {
        return payTime.next();
    }
}
