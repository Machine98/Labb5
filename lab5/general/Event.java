package lab5.general;
import lab5.general.State;

public abstract class Event {

    private double time;
    private State state;
    protected EventQueue eventQueue;


    public Event(State state, double time, EventQueue eventQueue){
        this.state = state;
        this.time = time;
    }

    public abstract void performEvent();

    public double EventTime(){
        return time;
    }
}
