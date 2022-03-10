package lab5;


import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.State;
import lab5.general.View;
import lab5.general.store.StartEvent;
import lab5.general.store.StoreState;
import lab5.general.store.StoreView;


public class SimMain {

    public static void main(String[] args) {
        int registers = 2;
        int maxCustomers = 5;
        double lambda = 0.5;
        double minPickTime = 1.0;
        double maxPickTime = 2.0;
        double minPayTime = 3.0;
        double maxPayTime = 10;
        long seed = 1234;

        StoreState storeState = new StoreState(seed, maxCustomers, registers, minPayTime, maxPayTime, minPickTime, maxPickTime, lambda);

        // eventqueue, Start, end och closing
        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));

        View view = new StoreView(storeState);
        storeState.addObserver(view);

        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.run();
    }
}
