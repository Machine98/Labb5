package lab5.general.store;

import lab5.general.State;
import lab5.general.View;

public class StoreView extends View {

    private State state;
    private StoreState storeState;

    public StoreView (State state, StoreState storeState){
        this.state = state;
        this.storeState = storeState;

    }
    private void firstPrint() {
        System.out.println("PARAMETRAR");
        System.out.println("==========");
        System.out.println("Antal kassor, N............:" + storeState.getRegisters());
        System.out.println("Max som rums, M............:" + storeState.getMaxCustomers());
        System.out.println("Ankomsthastighet, lambda...:" + storeState.getlambda());
        System.out.println("Plocktider, [P_min...P_max]: [" + storeState.getMinPickTime() + "..." + storeState.getMaxPickTime() + "]");
        System.out.println("Betaltider, [K_min...K_max]: [" + storeState.getMinPayTime() + "..." + storeState.getMaxPayTime() + "]");
        System.out.println("Frö, f.....................:" + storeState.getSeed());
    }

    private void lastPrint(){
        System.out.println("RESULTAT");
        System.out.println("========");
        System.out.println("1) Av " + storeState.getTotalCustomers() + " handlade " + storeState.getCustomersPayed()
                + " medan " + storeState.getCustomersTurnedAway() + " missades.");
        System.out.println("");
        System.out.println("2) Total tid " + storeState.getRegisters() + " kassor varit lediga: " + här i ska vi ta tid de varit lediga );
        System.out.println("\tGenomsnittlig legid kassa tid " + något + " (dvs " + procentenhet på medelvärdet + " av tiden från öppning tills sista kunden betalat).");
        System.out.println("");
        System.out.println("3) Total tid " + köade kunder + " kunder tvingats köa:" + tid de köat i te + ".");
        System.out.println("\tGenomsnittlig kötid: " + genomsnittlig kötid i te);


    }
    private void eventPrint(){
        String currentEvent = "" + storeState.getCurrentEvent().getEventName();
        //behöver ta emot kund id, lediga kassor, lediga kassor tid, I, antal kunder som betalat, missade kunder, köat, kötid, köar, kassakö


    }
}
