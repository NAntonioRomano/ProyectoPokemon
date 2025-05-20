package model.exceptions;

/**
 * ImpossiblePurchaseException is thrown when a purchase cannot be made
 */
public class ImpossiblePurchaseException extends Exception {
    private double cost;
    private double availableCost;

    /**
     * Constructor for ImpossiblePurchaseException
     *
     * @param cost          the cost of the item
     * @param availableCost the available cost
     */
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