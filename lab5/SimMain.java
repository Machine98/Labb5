package lab5;


import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.State;
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
        int maxCustomers = 5;
        double lambda = 1.0;
        double minPickTime = 0.5;
        double maxPickTime = 1.0;
        double minPayTime = 2.0;
        double maxPayTime = 3.0;
        double closeTime = 10.0;
        long seed = 1234;

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
