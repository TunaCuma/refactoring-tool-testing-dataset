package org.example.feature_envy.hard;

import java.util.*;

public class PaymentSummaryGenerator {
    /**
     * Generates a summary for payments: groups by currency with count, total, average.
     */
    public String generateSummary(PaymentData data) {
        if (data == null || data.getPayments() == null || data.getPayments().isEmpty()) {
            return "No payments available";
        }
        Map<String, List<Double>> groups = new HashMap<>();
        for (Payment p : data.getPayments()) {
            if (p == null) continue;
            groups.computeIfAbsent(p.getCurrency(), k -> new ArrayList<>()).add(p.getAmount());
        }
        StringBuilder sb = new StringBuilder("Summary:\n");
        for (Map.Entry<String, List<Double>> entry : groups.entrySet()) {
            List<Double> amounts = entry.getValue();
            double total = 0;
            for (double amt : amounts) total += amt;
            double avg = total / amounts.size();
            sb.append(entry.getKey())
              .append(": count=").append(amounts.size())
              .append(", total=").append(String.format("%.2f", total))
              .append(", avg=").append(String.format("%.2f", avg))
              .append("\n");
        }
        return sb.toString().trim();
    }
}

class PaymentData {
    private final List<Payment> payments;
    public PaymentData(List<Payment> payments) { this.payments = payments; }
    public List<Payment> getPayments() { return payments; }
}

class Payment {
    private final double amount;
    private final String currency;
    public Payment(double amount, String currency) {
        this.amount = amount; this.currency = currency;
    }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}
