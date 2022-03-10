package lab5.general;

import java.util.Observer;
import java.util.Observable;

public abstract class View implements Observer{

    private State state;

    public View() {
        this.state = state;
    }

    public void update(Observable o, Object arg) {

    }
}
