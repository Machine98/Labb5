package lab5.general;

import java.util.Observer;
import java.util.Observable;

import lab5.general.store.StoreSate;

public abstract class View implements Observer{

    private State state;
    private StoreSate storeState;

    public View() {
        state.addObserver(this);
    }

    public void update(Observable arg, object o); {

    }
}
