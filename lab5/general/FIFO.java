package lab5.general;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Represents a "First in first out" program
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class FIFO {
    private ArrayList<Object> queue = new ArrayList<Object>();
    private int maxSize = 0;

    /**
     * adds objects to queue
     *
     * @param o the object
     */

    public void add(Object o) {
        queue.add(o);
        maxSize++;
    }

    /**
     * Gets the object in the specific index
     *
     * @param index the index specified
     * @return returns the object in the specified index
     */

    public Object getIndex(int index) {
        return queue.get(index);
    }

    /**
     * Remove the object at index 0 (First object) if such an object exists
     *
     */

    public void removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            return;
        }
        this.queue.remove(0);
    }

    /**
     * Remove the object at a specified index if such an object exists
     *
     */

    public void removeIndex(int index) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        this.queue.remove(index);
    }

    /**
     * Remove the object if such an object exists
     *
     * @param item the object
     */

    public void removeOb(Object item) throws NoSuchElementException {
        if (isEmpty()) {

        }
        for (int i = 0; i < queue.size(); i++) {
            if (item.equals(queue.get(i))) {
                removeIndex(i);
            }
        }
    }

    /**
     * Get the first object in the arraylist
     *
     */

    public Object first() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue.get(0);
    }

    /**
     * Returns the max size of the arraylist
     *
     * @return the max size
     */

    public int maxSize() {
        return maxSize;
    }

    /**
     * Checks if the list is empty
     *
     * @return boolean true if empty, false if not empty
     */

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the current size of the list
     *
     * @return the size
     */

    public int size() {
        return this.queue.size();
    }

    /**
     * Checks if a list is the same as another list
     *
     * @return boolean
     */

    public boolean equals(Object f) {
        if (f.getClass() == this.getClass()) {

            if (((FIFO) f).queue.size() == this.queue.size()) {

                for (int i = 0; i < this.queue.size(); i++) {

                    if ((this.queue.get(i) == null) || (((FIFO) f).queue.get(i) == null)) {

                        if ((this.queue.get(i) == null) && (((FIFO) f).queue.get(i) == null)) {
                            continue;
                        }
                        return false;
                    } else if (((FIFO) f).queue.get(i).equals(this.queue.get(i))) {
                        continue;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            throw new ClassCastException();
        }
    }

    /**
     * Returns a String that says what is in a queue
     *
     * @return list to string
     */

    public String toString() {
        String printQueue = "Queue: ";
        for (Object o : queue) {
            printQueue += "(" + o + ") ";
        }
        return printQueue;
    }
}