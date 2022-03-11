package lab5.general;

import java.util.Observer;
import java.util.Observable;

import lab5.general.store.StoreState;

public abstract class View implements Observer{

    private State state;

    public View() {

        //state.addObserver(this);
    }

    @Override
    public void update(Observable arg0, Object f) {

    }
}
