package lab5.general;
import lab5.general.State;
import lab5.general.store.StoreState;

public abstract class Event {

    private double time;
    private StoreState state;
    protected EventQueue eventQueue;
    private boolean open;
    private String name;


    public Event(StoreState state, double time, EventQueue eventQueue){
        this.state = state;
        this.time = time;
    }

    public String getName(){
        return name;
    }

    public abstract void performEvent();

    public double EventTime(){
        return time;
    }

    public void isOpen(Boolean close){
        open = close;
    }
    public boolean getIsOpen(){
        return open;
    }
}
