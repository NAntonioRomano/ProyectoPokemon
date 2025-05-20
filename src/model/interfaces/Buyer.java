package model.interfaces;

import model.exceptions.ImpossiblePurchaseException;

/**
 * Buyer interface represents an entity that can purchase items.
 * It provides methods to get the balance and subtract an amount from it.
 */
public interface Buyer {

    /**
     * This method is called when a purchase is made.
     *
     * @param item The item to be purchased.
     * @throws ImpossiblePurchaseException if the purchase cannot be made due to
     *                                     insufficient funds for example.
     */
    default void purchase(Valuable item) throws ImpossiblePurchaseException {
        double cost = item.getCost();
        double balance = getBalance();

        if (balance < cost)
            throw new ImpossiblePurchaseException(cost, balance);

        item.deliverTo(this);

        subtract(cost);
    }

    /**
     * This method returns the balance of the buyer.
     *
     * @return The balance of the buyer.
     */
    double getBalance();

    /**
     * This method subtracts an amount from the buyer's balance.
     *
     * @param amount The amount to be subtracted.
     */
    void subtract(double amount);
}