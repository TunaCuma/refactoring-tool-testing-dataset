package org.example.long_method.easy;

public class DiscountApplier {
    /**
     * Applies tiered discounts based on purchase amount.
     */
    public double apply(double amount) {
        double discount = 0;
        if (amount > 1000) {
            discount = amount * 0.2;
        } else if (amount > 500) {
            discount = amount * 0.1;
        } else if (amount > 100) {
            discount = amount * 0.05;
        }
        double total = amount - discount;
        // apply membership fee
        if (amount > 200) {
            total -= 10;
        }
        return total;
    }
}
