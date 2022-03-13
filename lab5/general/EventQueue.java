package lab5.general;

/**
 * Represents the events queue in which each event will be run within the program
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class EventQueue extends FIFO {

    /**
     * Add a new event
     *
     * @param newEvent - The new event that will be added to the queue
     */

    public void addEvent(Event newEvent) {
        this.add(newEvent);
    }

    /**
     * Gets the next event
     *
     * @return - Gets the next event in the queue
     */

    public Event getNext() {
        Event newest = null;

        if (this.size() > 1) {
            for (int i = 0; i < this.size(); i++) {
                Event temp = (Event) this.getIndex(i);
                if (newest == null) {
                    newest = (Event) this.first();
                } else if (newest.EventTime() > temp.EventTime()) {
                    newest = temp;
                }
            }
        } else {
            newest = (Event) this.first();
            this.removeFirst();
        }
        removeOb(newest);
        return newest;
    }
}
