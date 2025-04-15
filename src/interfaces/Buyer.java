package interfaces;

import exceptions.ImpossiblePurchaseException;

public interface Buyer {
    default void purchase(Valuable item) throws ImpossiblePurchaseException {
        double cost = item.getCost();
        double balance = getBalance();

        if (balance < cost)
            throw new ImpossiblePurchaseException(cost, balance);

        item.deliverTo(this);

        subtract(cost);
    }

    double getBalance();

    void subtract(double amount);
}