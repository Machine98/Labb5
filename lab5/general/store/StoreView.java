package lab5.general.store;

import java.util.Observable;
import java.util.Observer;

import lab5.general.Event;
import lab5.general.store.StoreState;
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
        System.out.println("");
        System.out.println("FÖRLOPP");
        System.out.println("=======");
        System.out.println(
                "    Tid   Händelse     Kund    ?    led    ledT    I    $    :-(    köat    köT    köar    [Kassakö..]");
    }

    public void lastPrint(){
        System.out.println("");
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + storeState.getTotalCustomers() + " handlade " + storeState.getCustomersPayed() + " medan " + storeState.getCustomersTurnedAway() + " missades.");
        System.out.println("");
        System.out.println("2) Total tid " + storeState.getRegisters() + " kassor varit lediga: " + storeState.getUnoccupiedRegTime());
        //System.out.println("\tGenomsnittlig ledig kassa tid " + storeState.getUnoccupiedRegTime()/storeState.getRegisters() + " (dvs " + "procentenhet på medelvärdet" + " + " + "av tiden från öppning tills sista kunden betalat" + ".");
        System.out.println("");
        System.out.println("3) Total tid " + "köade kunder" + " kunder tvingats köa:" + "tid de köat i te" + ".");
        System.out.println("\tGenomsnittlig kötid: " + "genomsnittlig kötid i te");


    }

    public void update(Observable arg0, Object f) {
        String time = String.valueOf(String.format("%5.2f", storeState.getTimePassed())) + "   ";
        String event = "";

        if (storeState.getEventName() == "Ankomst"){
            event = "Ankomst       ";
        }
        else if (storeState.getEventName() == "Plock"){
            event = "Plock         ";
        }
        else if (storeState.getEventName() == "Betalning"){
            event = "Betalning     ";
        }
        else if (storeState.getEventName() == "Stänger"){
            event = "Stänger       ";
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



        String cusID = String.valueOf(storeState.getCurrentCustomerID()) + "      ";
        String store = (storeState.isOpen()) ? "Ö     " : "S     ";
        String availableReg = String.valueOf(String.format("%2d", storeState.getRegisters() - storeState.getOcupiedregisters()) + "   ");
        String timeFreeReg = String.valueOf(String.format("%5.2f", storeState.getUnoccupiedRegTime())) + "    ";
        String amCust = String.valueOf(storeState.getCurrentCustomers()) + "    ";
        String coinMade = String.valueOf(storeState.getCustomersPayed()) + "     ";
        String missCust = String.valueOf(storeState.getCustomersTurnedAway()) + "      ";
        String totAmQueue = String.valueOf(storeState.getTotAmQueue()) + "     ";
        String totTimeQueued = String.valueOf(String.format("%.2f", storeState.getTimeQueued())) + "     ";
        String amQueue = String.valueOf(storeState.customerQueue.size()) + "     ";



        String infoRow;
        if (event == "Start" || event == "Stänger       "){
            infoRow = time + event;
        }
        else {
            infoRow = time + event + cusID + store + availableReg + timeFreeReg + amCust + coinMade + missCust + totAmQueue + totTimeQueued + amQueue + currentQueue;
        }

        System.out.println("  " + infoRow);
    }
}
