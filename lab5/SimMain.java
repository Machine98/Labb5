package lab5;


import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.State;
import lab5.general.View;
import lab5.general.store.*;


public class SimMain {

    public static void main(String[] args) {
        int registers = 2;
        int maxCustomers = 5;
        double lambda = 1.0;
        double minPickTime = 0.5;
        double maxPickTime = 1.0;
        double minPayTime = 2.0;
        double maxPayTime = 3.0;
        long seed = 1234;

        StoreState storeState = new StoreState(seed, maxCustomers, registers, minPayTime, maxPayTime, minPickTime, maxPickTime, lambda);

        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));
        eventQueue.addEvent(new ClosingEvent(storeState, 10, eventQueue));
        eventQueue.addEvent(new EndEvent(storeState, 999, eventQueue));

        View view = new StoreView(storeState);
        storeState.addObserver(view);

        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.run();
    }
}
