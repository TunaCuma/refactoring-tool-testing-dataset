package org.example.long_method.easy;

public class OrderProcessor {
    /**
     * Processes an order by validating, calculating price, applying discounts, and returning summary.
     */
    public String processOrder(String customer, java.util.List<Double> prices, double discountRate) {
        // 1. Validate inputs
        if (customer == null || customer.isEmpty()) {
            throw new IllegalArgumentException("Customer required");
        }
        if (prices == null || prices.isEmpty()) {
            return "No items to process for " + customer;
        }
        // 2. Sum prices
        double sum = 0;
        for (Double p : prices) {
            if (p == null || p < 0) continue;
            sum += p;
        }
        // 3. Calculate discount
        double discount = sum * discountRate;
        double total = sum - discount;
        // 4. Format result
        StringBuilder sb = new StringBuilder();
        sb.append("Order for ").append(customer).append("\n");
        sb.append("Subtotal: $").append(String.format("%.2f", sum)).append("\n");
        sb.append("Discount: $").append(String.format("%.2f", discount)).append("\n");
        sb.append("Total: $").append(String.format("%.2f", total));
        return sb.toString();
    }
}
