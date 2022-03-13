package lab5;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.View;
import lab5.general.store.*;
import lab5.general.K;

import java.awt.*;
import java.util.Random;

/**
 * Represents the optimization of the number of cash registers.
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */


public class Optimize implements K{
    /**
     * Make calls to the optimization methods. (?)
     *
     */
    public static void main(String[] args) {

        optimizeRegisters(SEED); //metod 2
        //worstCaseOfOptReg(SEED); //metod 3
    }
    /**
     * Runs the simulation, without printing any data, and returns the final store state.
     *
     * @param registers - Amount of registers.
     * @param seed - The seed that is sent as an argument to optSimulator().
     *
     * @return finale store state.
     */
    private static StoreState optSimulator(int registers, long seed){

        StoreState storeState = new StoreState(seed, M, registers, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME,
                LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, L);

        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));
        eventQueue.addEvent(new ClosingEvent(storeState, END_TIME, eventQueue));
        eventQueue.addEvent(new EndEvent(storeState, STOP_TIME, eventQueue));

        View view = new StoreView(storeState);
        //storeState.addObserver(view);

        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.optRun();

        return storeState;
    }
    /**
     * Finds the lowest number of registers that minimizes the number of
     * missed customers for the given seed.
     *
     * @param seed - The seed that is sent as an argument to optSimulator().
     * @return Smallest amount of registers.
     */
    private static int optimizeRegisters(long seed) {
        StoreState newState;

        int optimalAmOfReg = 0;

        int missed = 99999;
        for (int i = M; i >= 1; i--) {
            newState = optSimulator(i,seed);

            if(missed < newState.getCustomersTurnedAway()) {
                break;
            }
            missed = newState.getCustomersTurnedAway();
            optimalAmOfReg = i;
        }

        printParam();
        System.out.print("Minsta antal kassor som ger minimalt antal missade ");
        System.out.println("("+missed+") "+optimalAmOfReg);
        return optimalAmOfReg;
    }
    /**
     * Test different seeds to find the highest return value of optimizeRegisters().
     *
     *
     * @param f - The seed to the random number generator, Random(f).
     *
     */
    private static void worstCaseOfOptReg(long f) {
        Random randomSeed = new Random(f);
        int loopsSinceChange = 0;
        int optimalAmOfReg = 1;
        while(true) {
            int newOptRegisters = optimizeRegisters(randomSeed.nextLong());

            if(newOptRegisters > optimalAmOfReg) {
                loopsSinceChange = 0;
                optimalAmOfReg = newOptRegisters;
            }
            else {
                loopsSinceChange++;
            }
            if(loopsSinceChange == 100){
                break;
            }
        }
        printParam();
        System.out.println("Worst case - minst antal kassor: "+optimalAmOfReg);

    }
    /**
     * Prints the parameters to the simulation, and the result of the optimization.
     *
     *
     *
     */
    private static void printParam() {
        System.out.println("Max som ryms, M..........: "+M);
        System.out.println("Ankomshastighet, lambda..: "+L);
        System.out.println("Plocktider, [P_min..Pmax]: "+"["+LOW_COLLECTION_TIME+" .. "+HIGH_COLLECTION_TIME+"]");
        System.out.println("Plocktider, [P_min..Pmax]: "+"["+LOW_PAYMENT_TIME+" .. "+HIGH_PAYMENT_TIME+"]");
        System.out.println("Frö, f...................: "+SEED);
        System.out.println("Stängning sker tiden "+END_TIME+" och stophändelsen sker tiden "+STOP_TIME);
    }

}
