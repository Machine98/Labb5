package lab5.general;

import java.util.Observer;
import java.util.Observable;

/**
 * Represents an abstract class View as observer
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public abstract class View implements Observer {

    private State state;

    public View() {
    }

    @Override
    public void update(Observable arg0, Object f) {
    }

    public abstract void firstPrint();

    public abstract void lastPrint();

}
