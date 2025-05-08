package org.example.strategy_pattern.medium;

public class ShippingCalculator {
    public double calculateShipping(String type, double weight) {
        if ("STANDARD".equals(type)) {
            return weight * 1.0;
        } else if ("EXPRESS".equals(type)) {
            return weight * 2.0 + 5;
        } else if ("OVERNIGHT".equals(type)) {
            return weight * 3.0 + 20;
        }
        throw new IllegalArgumentException("Unknown shipping type: " + type);
    }
}
