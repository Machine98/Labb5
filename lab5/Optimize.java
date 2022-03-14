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

        //optimizeRegisters(SEED); //metod 2
        worstCaseOfOptReg(SEED); // metod 3
    }
    /**
     * Runs the simulation, without printing any data, and returns the final store state.
     *
     * @param registers - Amount of registers.
     * @param seed - The seed that is sent as an argument to optSimulator().
     */
    private static StoreState optSimulator(int registers, long seed){

        // Creates a new store state with given parameters.
        StoreState storeState = new StoreState(seed, M, registers, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME,
                LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, L);

        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));
        eventQueue.addEvent(new ClosingEvent(storeState, END_TIME, eventQueue));
        eventQueue.addEvent(new EndEvent(storeState, STOP_TIME, eventQueue));

        View view = new StoreView(storeState);

        //Run the simulation without printing any data from it.
        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.optRun();

        return storeState;
    }
    /**
     * Finds the lowest number of registers that minimizes the number of
     * missed customers for the given seed.
     *
     * @param seed - The seed that is sent as an argument to optSimulator().
     */
    private static int[] optimizeRegisters(long seed) {
        StoreState newState;

        int[] optimalAmOfReg = {0,0};

        int missed = 99999;
        // Loops through different amount of registers
        for (int i = M; i >= 1; i--) {
            newState = optSimulator(i,seed);

            //break if amount of missed customer increases.
            if(missed < newState.getCustomersTurnedAway()) {
                break;
            }
            //otherwise set new missed and new optimal amount of registers.
            missed = newState.getCustomersTurnedAway();
            optimalAmOfReg[0] = i;
            optimalAmOfReg[1] = missed;
        }

        //printParam();
        //System.out.print("\nMinsta antal kassor som ger minimalt antal missade ");
        //System.out.println("("+missed+") "+optimalAmOfReg);
        return optimalAmOfReg;
    }
    /**
     * Test different seeds to find the highest return value of optimizeRegisters().
     *
     *
     * @param f - The seed to the random number generator, Random(f).
     */
    private static void worstCaseOfOptReg(long f) {
        //get random seed
        Random randomSeed = new Random(f);
        int loopsSinceChange = 0;
        int worstOptimalAmOfReg = 1;
        int missed = 0;
        while(true) {
            //get optimal amount of registers for a new random seed.
            int[] newOptRegisters = optimizeRegisters(randomSeed.nextLong());
            int tempBest = newOptRegisters[0];
            missed = newOptRegisters[1];
            //check if it's bigger than the last
            if(tempBest > worstOptimalAmOfReg) {
                loopsSinceChange = 0;
                //and if it is, set new worstOptimalAmOfReg and reset the counter.
                worstOptimalAmOfReg = tempBest;
            }
            else {
                //If it's not bigger, then increase the counter.
                loopsSinceChange++;
            }

            if(loopsSinceChange == 100){
                break;
            }
        }
        printParam();
        System.out.println("\nWorst case - minst antal kassor: "+" ("+missed+") "+worstOptimalAmOfReg);
    }

    private static void printParam() {
        System.out.println("Max som ryms, M..........: "+M);
        System.out.println("Ankomshastighet, lambda..: "+L);
        System.out.println("Plocktider, [P_min..Pmax]: "+"["+LOW_COLLECTION_TIME+" .. "+HIGH_COLLECTION_TIME+"]");
        System.out.println("Plocktider, [P_min..Pmax]: "+"["+LOW_PAYMENT_TIME+" .. "+HIGH_PAYMENT_TIME+"]");
        System.out.println("Frö, f...................: "+SEED);
        System.out.println("\nStängning sker tiden "+END_TIME+" och stophändelsen sker tiden "+STOP_TIME);
    }

}
