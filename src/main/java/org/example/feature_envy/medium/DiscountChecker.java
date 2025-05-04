package org.example.feature_envy.medium;

public class DiscountChecker {
    /**
     * Checks if a customer is eligible for a discount.
     */
    public boolean isEligible(Customer c) {
        if (c == null || c.getPurchaseHistory().length == 0) return false;
        double sum = 0;
        for (double d : c.getPurchaseHistory()) sum += d;
        double avg = sum / c.getPurchaseHistory().length;
        return avg > 1000 && c.getLoyaltyPoints() >= 500;
    }
}

class Customer {
    private final double[] purchaseHistory;
    private final int loyaltyPoints;
    public Customer(double[] purchaseHistory, int loyaltyPoints) {
        this.purchaseHistory = purchaseHistory; this.loyaltyPoints = loyaltyPoints;
    }
    public double[] getPurchaseHistory() { return purchaseHistory; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
}
