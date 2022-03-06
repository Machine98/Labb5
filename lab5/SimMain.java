package lab5;


import lab5.general.Simulator;
import lab5.general.View;
import lab5.general.store.StoreSate;
import lab5.general.store.StoreView;


public class SimMain {

    public static void main(String[] args) {
        long seed = 1234;
        int maxCustomers = 10;
        int registers = 4;
        double closingTime = 1000;
        double minPickTime = 0.5;
        double maxPickTime = 1;
        double minPayTime = 2;
        double maxPayTime = 3;
        double lambda = 1;


        StoreSate state = new StoreSate(seed, maxCustomers, registers, closingTime, minPayTime, maxPayTime, minPickTime, maxPickTime, lambda);
        StoreView view = new View(state, state.getStore());

        Simulator simulator = new Simulator(state, view);


    }
}
