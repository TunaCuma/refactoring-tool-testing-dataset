package org.example.strategy_pattern.easy;

public class DiscountApplier {
    /**
     * Applies discount based on customer type.
     */
    public double applyDiscount(String customerType, double price) {
        double finalPrice;
        if (customerType.equals("REGULAR")) {
            finalPrice = price * 0.95;
        } else if (customerType.equals("PREMIUM")) {
            finalPrice = price * 0.90;
        } else if (customerType.equals("VIP")) {
            finalPrice = price * 0.85;
        } else {
            finalPrice = price;
        }
        return finalPrice;
    }
}
