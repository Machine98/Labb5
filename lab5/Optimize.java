package lab5;

import lab5.general.EventQueue;
import lab5.general.Simulator;
import lab5.general.View;
import lab5.general.store.*;

import java.awt.*;
import java.util.Random;

public class Optimize {

    public static void main(String[] args) {

        metod1(2,1234);
        metod2(1234);
        metod3(1234);
    }
    private static StoreState metod1(int registers, long seed){

        int maxCustomers = 5;
        double lambda = 2.0;
        double minPickTime = 0.5;
        double maxPickTime = 1.0;
        double minPayTime = 2.0;
        double maxPayTime = 3.0;


        StoreState storeState = new StoreState(seed, maxCustomers, registers, minPickTime, maxPickTime, minPayTime, maxPayTime, lambda);

        EventQueue eventQueue = new EventQueue();

        eventQueue.addEvent(new StartEvent(storeState, 0, eventQueue));
        eventQueue.addEvent(new ClosingEvent(storeState, 10, eventQueue));
        eventQueue.addEvent(new EndEvent(storeState, 999999, eventQueue));

        View view = new StoreView(storeState);
        //storeState.addObserver(view);

        Simulator simulator = new Simulator(storeState, view, eventQueue);
        simulator.optRun();
        //System.out.println(storeState.getCustomersTurnedAway());
        return storeState;
    }
    private static int metod2(long seed) {
        StoreState newState;

        int optimalAmOfReg = 0;

        int compare = 999999;
        for (int i = 5; i >= 1; i--) {
            newState = metod1(i,seed);
            //System.out.println(newState.getCustomersTurnedAway());
            if(compare < newState.getCustomersTurnedAway()) {
                break;
            }
            compare = newState.getCustomersTurnedAway();
            optimalAmOfReg = i;
        }
        //System.out.println(optimalAmOfReg);
        return optimalAmOfReg;
    }

    private static void metod3(long f) {
        Random randomSeed = new Random(f);
        int loopsSinceChange = 0;
        int optimalAmOfReg = 0;
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
        System.out.println(optimalAmOfReg);
    }
}
