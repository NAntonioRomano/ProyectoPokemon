package exceptions;

public class ImpossiblePurchaseException extends Exception {
    private double cost;
    private double availableCost;

    public ImpossiblePurchaseException(double cost, double availableCost) {
        super("No se puede realizar la compra");
        this.cost = cost;
        this.availableCost = availableCost;
    }

}