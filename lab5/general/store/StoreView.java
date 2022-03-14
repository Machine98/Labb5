package lab5.general.store;

import java.util.Observable;

import lab5.general.View;

/**
 * Represents the programs function of printing out the simulation data
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class StoreView extends View {

    private StoreState storeState;
    private Customer customerID;


    /**
     * Constructor
     *
     * @param storeState contains all valuable data needed, and the specific event
     */

    public StoreView(StoreState storeState) {
        this.storeState = storeState;
    }


    /**
     * Handles the first print that includes the simulations parameters
     */

    @Override
    public void firstPrint() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N............:" + storeState.getRegisters());
        System.out.println("Max som rums, M............:" + storeState.getMaxCustomers());
        System.out.println("Ankomsthastighet, lambda...:" + storeState.getlambda());
        System.out.println("Plocktider, [P_min...P_max]: [" + storeState.getMinPickTime() + "..." +
                storeState.getMaxPickTime() + "]");
        System.out.println("Betaltider, [K_min...K_max]: [" + storeState.getMinPayTime() + "..." +
                storeState.getMaxPayTime() + "]");
        System.out.println("Frö, f.....................:" + storeState.getSeed());

        System.out.println("\nFÖRLOPP");
        System.out.println("=======");
        String header = String.format("%-5s\t %-10s %-6s %-5s %-10s %s\t %-10s %-9s %-10s %-11s %-8s %-13s %s",
                "Tid", "Händelse", "Kund", "?", "led", "ledT", "I", "$", ":-(", "köat", "köT", "köar", "[Kassakö..]");
        System.out.println(header);
    }

    /**
     * Handles the last print that includes the simulations results
     */

    @Override
    public void lastPrint() {
        System.out.println("");
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("\n1) Av " + storeState.getTotalCustomers() + " handlade " + storeState.getCustomersPayed() +
                " medan " + storeState.getCustomersTurnedAway() + " missades.");
        System.out.println("");
        System.out.println("2) Total tid " + storeState.getRegisters() + " kassor varit lediga: " + String.format("%.2f"
                , storeState.getUnoccupiedRegTime()) + " te.");
        System.out.println("\tGenomsnittlig ledig kassatid: " + String.format("%.2f", storeState.getUnoccupiedRegTime()
                / storeState.getRegisters()) + " te (dvs " + String.format("%.2f", ((storeState.getUnoccupiedRegTime() /
                storeState.getRegisters()) / storeState.getSecondToLastEventTime()) * 100) + "%  av tiden från " +
                "öppning tills sista kunden betalat).");
        System.out.println("");
        System.out.println("3) Total tid " + storeState.getTotAmQueue() + " kunder tvingats köa: " +
                String.format("%.2f", storeState.getTimeQueued()) + " te" + ".");
        System.out.println("\tGenomsnittlig kötid: " + String.format("%.2f", storeState.getTimeQueued() /
                storeState.getTotAmQueue()) + " te.");
    }

    /**
     * Prints data from the specific event
     *
     * @param arg0 - arg0
     * @param f    - f
     */


    public void update(Observable arg0, Object f) {

        String currentQueue = "[";
        for (int i = 0; i < storeState.customerQueue.size(); i++) {
            customerID = (Customer) storeState.customerQueue.getIndex(i);
            if (storeState.customerQueue.size() == i + 1) {
                currentQueue = currentQueue + String.valueOf(customerID.getCustomerID());
            } else {
                currentQueue = currentQueue + String.valueOf(customerID.getCustomerID()) + ", ";
            }
        }
        currentQueue = currentQueue + "]";

        String infoRow;
        if (storeState.getEventName() == "Stänger") {
            infoRow = String.format("%.2f\t %-13s %-3s %-7s %-8s %.2f\t %-10s %-10s %-12s %-7s %-8.2f\t %-10s %s",
                    storeState.getTimePassed(),
                    storeState.getEventName(), "---", storeState.isOpen() ? "Ö" : "S", storeState.getRegisters() -
                            storeState.getOcupiedregisters(),
                    storeState.getUnoccupiedRegTime(), storeState.getCurrentCustomers(), storeState.getCustomersPayed(),
                    storeState.getCustomersTurnedAway(), storeState.getTotAmQueue(), storeState.getTimeQueued(),
                    storeState.customerQueue.size(), currentQueue + "\n");
        } else if (storeState.getEventName() == "Start") {
            infoRow = String.format("%.2f\t %-10s", storeState.getTimePassed(), storeState.getEventName()) + "\n";
        } else if (storeState.getEventName() == "Stop") {
            infoRow = String.format("%.2f\t %-10s", storeState.getTimePassed(), storeState.getEventName()) + "\n";
        } else {
            infoRow = String.format("%.2f\t %-13s %-3s %-7s %-8s %.2f\t %-10s %-10s %-12s %-7s %-8.2f\t %-10s %s",
                    storeState.getTimePassed(),
                    storeState.getEventName(), storeState.getCurrentCustomerID(), storeState.isOpen() ? "Ö" : "S",
                    storeState.getRegisters() - storeState.getOcupiedregisters(),
                    storeState.getUnoccupiedRegTime(), storeState.getCurrentCustomers(), storeState.getCustomersPayed(),
                    storeState.getCustomersTurnedAway(), storeState.getTotAmQueue(), storeState.getTimeQueued(),
                    storeState.customerQueue.size(), currentQueue + "\n");
        }
        System.out.print(infoRow);
    }
}
