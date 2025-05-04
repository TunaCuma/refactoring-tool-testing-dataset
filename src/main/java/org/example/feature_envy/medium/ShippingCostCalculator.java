package org.example.feature_envy.medium;

public class ShippingCostCalculator {
    /**
     * Calculates shipping cost based on order details.
     */
    public double calculateCost(Order order) {
        if (order == null) return 0.0;
        double base = order.getWeight() * order.getDistance() * order.getRatePerKgPerKm();
        double surcharge = order.isFragile() ? 10.0 : 0.0;
        return base + surcharge;
    }
}

class Order {
    private final double weight;
    private final double distance;
    private final double ratePerKgPerKm;
    private final boolean fragile;
    public Order(double weight, double distance, double ratePerKgPerKm, boolean fragile) {
        this.weight = weight;
        this.distance = distance;
        this.ratePerKgPerKm = ratePerKgPerKm;
        this.fragile = fragile;
    }
    public double getWeight() { return weight; }
    public double getDistance() { return distance; }
    public double getRatePerKgPerKm() { return ratePerKgPerKm; }
    public boolean isFragile() { return fragile; }
}
