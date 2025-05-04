package org.example.feature_envy.easy;

public class InvoiceCalculator {
    /**
     * Calculates a late fee based solely on the invoice's data.
     */
    public double calculateLateFee(Invoice invoice) {
        if (invoice == null) return 0.0;
        return invoice.getDaysOverdue() * invoice.getTotalAmount() * 0.01;
    }
}

class Invoice {
    private final int daysOverdue;
    private final double totalAmount;
    public Invoice(int daysOverdue, double totalAmount) {
        this.daysOverdue = daysOverdue;
        this.totalAmount = totalAmount;
    }
    public int getDaysOverdue() { return daysOverdue; }
    public double getTotalAmount() { return totalAmount; }
}
