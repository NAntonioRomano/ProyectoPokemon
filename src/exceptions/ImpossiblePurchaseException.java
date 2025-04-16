package exceptions;

public class ImpossiblePurchaseException extends Exception {
    private double cost;
    private double availableCost;

    public ImpossiblePurchaseException(double cost, double availableCost) {
        super("Insufficient funds to make the purchase: $" + cost + " - $" + availableCost);
        this.cost = cost;
        this.availableCost = availableCost;
    }

    public double getCost() {
        return cost;
    }

    public double getAvailableCost() {
        return availableCost;
    }

    @Override
    public String toString() {
        return "ImpossiblePurchaseException [cost=" + cost + ", availableCost=" + availableCost + "]";
    }
}