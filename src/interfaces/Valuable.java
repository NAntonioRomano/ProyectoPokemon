package interfaces;

/**
 * Valuable interface represents an object that has a cost and can be purchased.
 */
public interface Valuable {

    /**
     * This method returns the cost of the object.
     *
     * @return The cost of the object.
     */
    double getCost();

    /**
     * This method delivers the object to the buyer.
     *
     * @param buyer The buyer to whom the object is delivered.
     */
    void deliverTo(Buyer buyer);
}
