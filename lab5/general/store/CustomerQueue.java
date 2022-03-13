package lab5.general.store;

import lab5.general.FIFO;

public class CustomerQueue {
    FIFO customerFIFO;

    public CustomerQueue() {
        customerFIFO = new FIFO();
    }

    public void add(Customer customer) {
        customerFIFO.add(customer);
    }

    public void remove() {
        customerFIFO.removeFirst();
    }

    public Object first() {
        return customerFIFO.first();
    }

    public Object getIndex(int index) {
        return customerFIFO.getIndex(index);
    }

    public int size() {
        return customerFIFO.size();
    }
}
