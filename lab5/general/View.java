package lab5.general;

import java.util.Observer;
import java.util.Observable;
import lab5.general.store.StoreState;

public class View implements Observer{

    private State state;
    public View() {
        state.addObserver(this);
    }

    public void update(Observable arg, object o); {

    }
}
