package lab5.general;

public abstract class Event {

    private double time;

    public State state;

    public EventQueue eventQueue;

    public Event(State state, double time, EventQueue eventQueue){
        this.state = state;
        this.time = time;
        this.eventQueue = eventQueue;
    }

    public void executeEvent();
    public int eventID(Object indexValue) {
        return id;
    }
}
