package lab5.general.store;

/**
 * Represents a customer in the store
 *
 * @author Calle Rautio
 * @author Wilhelm Rauston
 * @author Albin Sundström
 * @author Eric Vikberg
 */

public class Customer {
    private int customerID;

    /**
     * Constructor
     *
     * @param id - The id of the customer
     */

    public Customer(int id) {
        setCustomerID(id);
    }

    /**
     * Sets the customer id
     *
     * @param id - The id of the customer
     */

    public void setCustomerID(int id) {
        this.customerID = id;
    }

    /**
     * Gets the customer id
     *
     * @return - the id of the customer
     */
    public int getCustomerID() {
        return this.customerID;
    }
}
