package models;

import exceptions.ImpossiblePurchaseException;
import interfaces.Buyer;
import interfaces.Valuable;

public abstract class AbstractBuyer implements Buyer {

    @Override
    public void purchase(Valuable item) throws ImpossiblePurchaseException {
        double cost = item.getCost();
        double balance = getBalance();

        if (balance < cost)
            throw new ImpossiblePurchaseException(cost, balance);

        item.deliverTo(this);

        subtract(cost);
    }
}
