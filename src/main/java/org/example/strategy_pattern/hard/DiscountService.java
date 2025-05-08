package org.example.strategy_pattern.hard;

public class DiscountService {
    public double applyDiscount(String type, double price) {
        if (type.equals("STUDENT")) {
            return price * 0.8;
        } else if (type.equals("SENIOR")) {
            return price * 0.7;
        } else if (type.equals("EMPLOYEE")) {
            return price * 0.5;
        }
        return price;
    }
}
