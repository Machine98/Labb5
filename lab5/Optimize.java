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

        //metod1(2,SEED);
        metod2(SEED);
        //metod3(SEED);
    }
    /**
     * Runs the simulation, without printing any data, and returns the final state.
     *
     *
     * @param seed - The seed that is sent as an argument to metod1().
     */
    private static StoreState metod1(int registers, long seed){

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
        //System.out.println(storeState.getCustomersTurnedAway());
        return storeState;
    }
    /**
     * Finds the lowest number of registers that minimizes the number of
     * missed customers for the given seed.
     *
     * @param seed - The seed that is sent as an argument to metod1().
     */
    private static int metod2(long seed) {
        StoreState newState;

        int optimalAmOfReg = 0;

        int missed = 99999;
        for (int i = M; i >= 1; i--) {
            newState = metod1(i,seed);
            //System.out.println(newState.getCustomersTurnedAway());
            if(missed < newState.getCustomersTurnedAway()) {
                break;
            }
            missed = newState.getCustomersTurnedAway();
            optimalAmOfReg = i;
        }

        System.out.println("Minst antal kassor: "+"("+missed+") "+optimalAmOfReg);
        return optimalAmOfReg;
    }
    /**
     * Test different seeds to find the highest return value of metod2().
     *
     *
     * @param f - The seed to the random number generator, Random(f).
     */
    private static void metod3(long f) {
        Random randomSeed = new Random(f);
        int loopsSinceChange = 0;
        int optimalAmOfReg = 1;
        while(true) {
            int newOptRegisters = metod2(randomSeed.nextLong());

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
        System.out.print("Worst case - minst antal kassor: "+optimalAmOfReg);

    }

}
