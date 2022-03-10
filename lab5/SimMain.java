package lab5;


import lab5.general.Simulator;
import lab5.general.State;
import lab5.general.View;
import lab5.general.store.StoreState;
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


        StoreState storeState = new StoreState(seed, maxCustomers, registers, closingTime, minPayTime, maxPayTime, minPickTime, maxPickTime, lambda);
        State state = new State();
        View view = new View(state, storeState);

        Simulator simulator = new Simulator(state, view);
        simulator.run();


    }
}
