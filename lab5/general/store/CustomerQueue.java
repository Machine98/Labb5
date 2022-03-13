package lab5.general.store;

import lab5.general.FIFO;

/**
 * Represents the checkout queue for when they are waiting to receive a register
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class CustomerQueue {
    FIFO customerFIFO;

    /**
     * Constructor
     */

    public CustomerQueue() {
        customerFIFO = new FIFO();
    }

    /**
     * Adds a customer to the queue
     *
     * @param customer - The specific customer
     */

    public void add(Customer customer) {
        customerFIFO.add(customer);
    }

    /**
     * Removes the first customer from the queue
     */

    public void remove() {
        customerFIFO.removeFirst();
    }

    /**
     * Returns the first customer from the queue
     *
     * @return - the first customer
     */

    public Object first() {
        return customerFIFO.first();
    }

    /**
     * Returns a specific customer depending on where in the queue he is located
     *
     * @param index - The position in the queue
     *
     * @return - Returns that customer
     */

    public Object getIndex(int index) {
        return customerFIFO.getIndex(index);
    }

    /**
     * The current size of the queue
     *
     * @return - The current size
     */

    public int size() {
        return customerFIFO.size();
    }
}
