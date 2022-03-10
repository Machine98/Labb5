package lab5.general;

import java.util.Observer;
import java.util.Observable;

import lab5.general.store.StoreState;

public abstract class View implements Observer{

    private State state;
    private StoreState storeState;

    public View() {
        state.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
