package lab5.general;

public class Simulator {

    private State state;
    private EventQueue eventQueue;
    private View view;

    public Simulator(State state, View view){
        this.state = state;
        this.view = view;
        this.eventQueue = new EventQueue();
    }

    public void run() {


    }
}
