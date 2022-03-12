package lab5.general;
import lab5.general.store.StoreState;

public abstract class Event {

    private double time;
    private StoreState storeState;
    protected EventQueue eventQueue;
    private String name;


    public Event(StoreState storeState, double time, EventQueue eventQueue){
        this.storeState = storeState;
        this.time = time;
        this.eventQueue = eventQueue;
    }

    public abstract String getName();

    public abstract void performEvent();

    public double EventTime(){
        return time;
    }


}
