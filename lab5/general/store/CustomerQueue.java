package lab5.general.store;

import lab5.general.FIFO;

public class CustomerQueue {

    private FIFO customerFIFO;

    public CustomerQueue() {
        this.customerFIFO = new FIFO();
    }
}
