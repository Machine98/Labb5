package lab5.general;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO {
    private ArrayList<Object> queue = new ArrayList<Object>();
    private int maxSize = 0;

    public void add(Object o) {
        queue.add(o);
        maxSize++;
    }

    public Object getIndex(int index){
        return queue.get(index);
    }

    public void removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            return;
        }
        this.queue.remove(0);
    }

    public void removeIndex(int index) throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        this.queue.remove(index);
    }

    public void removeOb(Object item) throws NoSuchElementException {
        if (isEmpty()) {

        }
        for (int i = 0; i < queue.size(); i++) {
            if (item.equals(queue.get(i))){
                removeIndex(i);
            }
        }
    }

    public Object first() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue.get(0);
    }

    public int maxSize() {
        return maxSize;
    }

    public boolean isEmpty() {
        if (queue.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.queue.size();
    }

    public boolean equals(Object f) {
        if (f.getClass() == this.getClass()) {

            if (((FIFO) f).queue.size() == this.queue.size()) {

                for (int i = 0; i < this.queue.size(); i++) {

                    if ((this.queue.get(i) == null) || (((FIFO) f).queue.get(i) == null)) {

                        if ((this.queue.get(i) == null) && (((FIFO) f).queue.get(i) == null)) {
                            continue;
                        }
                        return false;
                    }

                    else if (((FIFO) f).queue.get(i).equals(this.queue.get(i))) {
                        continue;
                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            throw new ClassCastException();
        }
    }

    public String toString() {
        String printQueue = "Queue: ";
        for (Object o : queue) {
            printQueue += "(" + o + ") ";
        }
        return printQueue;
    }
}