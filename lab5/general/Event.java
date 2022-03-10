package lab5.general;

public abstract class Event {

    private double time;
    private State state;
    private EventQueue eventQueue;
    private int eventID;


    public Event(State state, double time, EventQueue eventQueue, int eventId){
        this.state = state;
        this.time = time;
        this.eventQueue = eventQueue;
        this.eventID = eventId;
    }

    public abstract void performEvent();

    public int EventID(){
        return eventID;
    }
}
