package exceptions;

public class ImpossiblePurchaseException extends Exception {
    private double cost;
    private double availableCost;

    public ImpossiblePurchaseException(double cost, double availableCost) {
        super("Fondos insuficientes para realizar la compra: $" + cost + " - $" + availableCost);
        this.cost = cost;
        this.availableCost = availableCost;
    }

}