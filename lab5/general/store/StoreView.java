package lab5.general.store;

import java.util.Observable;
import lab5.general.View;

public class StoreView extends View {

    private StoreState storeState;
    private Customer customerID;

    public StoreView(StoreState storeState){
        this.storeState = storeState;
    }

    public void firstPrint() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N............:" + storeState.getRegisters());
        System.out.println("Max som rums, M............:" + storeState.getMaxCustomers());
        System.out.println("Ankomsthastighet, lambda...:" + storeState.getlambda());
        System.out.println("Plocktider, [P_min...P_max]: [" + storeState.getMinPickTime() + "..." + storeState.getMaxPickTime() + "]");
        System.out.println("Betaltider, [K_min...K_max]: [" + storeState.getMinPayTime() + "..." + storeState.getMaxPayTime() + "]");
        System.out.println("Frö, f.....................:" + storeState.getSeed());

        System.out.println("\nFÖRLOPP");
        System.out.println("=======");
        String förlopp = String.format("%-5s\t %-10s %-10s %-10s %-10s %s\t %-10s %-9s %-10s %-11s %-3s\t %-10s %s","Tid","Händelse","Kund", "?","led", "ledT" ,"I", "$",":-(", "köat","köT","köar","[Kassakö..]\n");
        System.out.println(förlopp);
    }

    public void lastPrint(){
        System.out.println("");
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + storeState.getTotalCustomers() + " handlade " + storeState.getCustomersPayed() + " medan " + storeState.getCustomersTurnedAway() + " missades.");
        System.out.println("");
        System.out.println("2) Total tid " + storeState.getRegisters() + " kassor varit lediga: " + String.format("%.2f",storeState.getUnoccupiedRegTime()));
        System.out.println("\tGenomsnittlig ledig kassa tid " + String.format("%.2f",storeState.getUnoccupiedRegTime()/storeState.getTotAmQueue()) + " (dvs " + String.format("%.2f",((storeState.getUnoccupiedRegTime()/storeState.getTotAmQueue())/storeState.getLastEventTime())*100) + " % " + "av tiden från öppning tills sista kunden betalat" + ".");
        System.out.println("");
        System.out.println("3) Total tid " + storeState.getTotAmQueue() + " kunder tvingats köa: " + String.format("%.2f",storeState.getTimeQueued()) + " te" + ".");
        System.out.println("\tGenomsnittlig kötid: " + String.format("%.2f",storeState.getTotAmQueue()/storeState.getTimeQueued()) + " te");


    }

    public void update(Observable arg0, Object f) {
        String event = "";

        if (storeState.getEventName() == "Ankomst"){
            event = "Ankomst";
        }
        else if (storeState.getEventName() == "Plock"){
            event = "Plock";
        }
        else if (storeState.getEventName() == "Betalning"){
            event = "Betalning";
        }
        else if (storeState.getEventName() == "Stänger"){
            event = "Stänger";
        }
        else {
            event = storeState.getEventName();
        }
        String currentQueue = "[";
        for (int i = 0; i < storeState.customerQueue.size(); i ++){
            customerID = (Customer) storeState.customerQueue.getIndex(i);
            if (storeState.customerQueue.size() == i + 1){
                currentQueue = currentQueue + String.valueOf(customerID.getCustomerID());
            }
            else{
                currentQueue = currentQueue + String.valueOf(customerID.getCustomerID()) + ", ";
            }
        }
        currentQueue = currentQueue + "]";

        String infoRow;
        infoRow = String.format("%.2f\t %-10s %-10s %-10s %-10s %.2f\t %-10s %-10s %-10s %-10s %.2f\t %-10s %s", storeState.getTimePassed(),
                event, storeState.getCurrentCustomerID(), storeState.isOpen() ? "O" : "C", storeState.getRegisters() - storeState.getOcupiedregisters(),
                storeState.getUnoccupiedRegTime(), storeState.getCurrentCustomers(), storeState.getCustomersPayed(),
                storeState.getCustomersTurnedAway(), storeState.getTotAmQueue(), storeState.getTimeQueued(),
                storeState.customerQueue.size(), currentQueue + "\n");

        System.out.print(infoRow);
    }
}
