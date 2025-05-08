package org.example.strategy_pattern.medium;

public class PaymentProcessor {
    public String processPayment(String method, double amount) {
        if ("CREDIT_CARD".equals(method)) {
            return "Processed credit card: $" + amount;
        } else if ("PAYPAL".equals(method)) {
            return "Processed PayPal: $" + amount + " with fee $" + (amount * 0.03);
        } else if ("BITCOIN".equals(method)) {
            return "Processed Bitcoin: ฿" + (amount / 50000);
        }
        throw new UnsupportedOperationException("Payment method not supported: " + method);
    }
}
