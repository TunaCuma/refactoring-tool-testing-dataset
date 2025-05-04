package org.example.long_method.easy;

public class InvoiceCalculator {
    /**
     * Calculates invoice totals by summing items, adding tax and fees.
     */
    public double calculateInvoice(java.util.List<Double> items, double taxRate, double fee) {
        // Sum items
        double sum = 0;
        for (Double item : items) {
            if (item != null && item > 0) sum += item;
        }
        // Apply tax
        double tax = sum * taxRate;
        // Final total
        return sum + tax + fee;
    }
}
