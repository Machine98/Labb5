package lab5.general;

import java.util.Observer;
import java.util.Observable;

public abstract class View implements Observer {

    private State state;

    public View() {
    }

    @Override
    public void update(Observable arg0, Object f) {
    }
}
