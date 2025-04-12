package interfaces;

import exceptions.ImpossiblePurchaseException;

public interface Buyer {
    void purchase(Valuable item) throws ImpossiblePurchaseException;

    double getBalance();

    void subtract(double amount);
}