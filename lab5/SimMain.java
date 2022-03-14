package lab5;


import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.View;
import lab5.general.store.*;

/**
 * Represents the programs core, here we define the simulations conditions
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */


public class SimMain {

    /**
     * (i) Creates constants that define the specific state
     * (ii) Creates instances of StoreState, View, Simulator
     * (iii) Creates crucial parts of the simulation regulating the startEvent, closingEvent, endEvent
     */

    public static void main(String[] args) {
        int registers = 2;
        int maxCustomers = 7;
        double lambda = 3.0;
        double minPickTime = 0.6;
        double maxPickTime = 0.9;
        double minPayTime = 0.35;
        double maxPayTime = 0.6;
        double closeTime = 8.0;
        long seed = 13;

        StoreState storeState = new StoreState(seed, maxCustomers, registers, minPickTime, maxPickTime, minPayTime, maxPayTime, lambda);

        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));
        eventQueue.addEvent(new ClosingEvent(storeState, closeTime, eventQueue));
        eventQueue.addEvent(new EndEvent(storeState, 999, eventQueue));

        View view = new StoreView(storeState);
        storeState.addObserver(view);

        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.run();
    }
}
