package org.example.strategy_pattern.medium;

public class DiscountService {
    public double applyDiscount(String customerType, double price) {
        if ("REGULAR".equals(customerType)) {
            return price * 0.95;
        } else if ("GOLD".equals(customerType)) {
            return price * 0.90;
        } else if ("PLATINUM".equals(customerType)) {
            return price * 0.85;
        }
        return price;
    }
}
