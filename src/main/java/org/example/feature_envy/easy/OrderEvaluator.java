package org.example.feature_envy.easy;

public class OrderEvaluator {
    /**
     * Returns true if order total exceeds a threshold.
     */
    public boolean isLargeOrder(Order order) {
        if (order == null) return false;
        return order.getQuantity() * order.getUnitPrice() > 1000;
    }
}

class Order {
    private final int quantity;
    private final double unitPrice;
    public Order(int quantity, double unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
}
