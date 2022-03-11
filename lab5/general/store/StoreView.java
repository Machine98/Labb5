package lab5.general.store;

import java.util.Observable;
import java.util.Observer;

import lab5.general.store.StoreState;
import lab5.general.View;

public class StoreView extends View {

    private StoreState storeState;

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
    }

    public void lastPrint(){
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + storeState.getTotalCustomers() + " handlade " + storeState.getCustomersPayed() + " medan " + storeState.getCustomersTurnedAway() + " missades.");
        System.out.println("");
        //System.out.println("2) Total tid " + storeState.getRegisters() + " kassor varit lediga: " + här i ska vi ta tid de varit lediga );
        //System.out.println("\tGenomsnittlig ledig kassa tid " + något + " (dvs " + "procentenhet på medelvärdet" + " + " + "av tiden från öppning tills sista kunden betalat" + ".");
        System.out.println("");
        System.out.println("3) Total tid " + "köade kunder" + " kunder tvingats köa:" + "tid de köat i te" + ".");
        System.out.println("\tGenomsnittlig kötid: " + "genomsnittlig kötid i te");


    }
    public void eventPrint(){

        //behöver ta emot kund id, lediga kassor, lediga kassor tid, I, antal kunder som betalat, missade kunder, köat, kötid, köar, kassakö



    }

    public void update(Observable arg0, Object f) {
        String time = String.valueOf(String.format("%.2f", storeState.getTimePassed())) + "    ";
        String event = "";

        if (storeState.getEventName() == "Ankomst"){
            event = "Ankomst    ";
        }
        else if (storeState.getEventName() == "Plock"){
            event = "Plock      ";
        }
        else if (storeState.getEventName() == "Betalning"){
            event = "Betalning  ";
        }
        else if (storeState.getEventName() == "Stänger"){
            event = "Stänger    ";
        }
        else {
            event = storeState.getEventName();
        }


        //String cusID = String.valueOf(storeState.getCustomerID) + "  ";
        //String availableReg = String.valueOf(storeState.getAvailableRegisters());
        String timeFreeReg = String.valueOf(String.format(".2f", storeState.getUnoccupiedRegTime()));
        String amCust = String.valueOf(storeState.getCurrentCustomers());
        String missCust = String.valueOf(storeState.getCustomersTurnedAway());
        //String timeQueued = String.valueOf()

        String infoRow;
        infoRow = time + event + timeFreeReg + amCust + missCust;

        System.out.println(infoRow);
    }
}
