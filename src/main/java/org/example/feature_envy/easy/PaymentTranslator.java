package org.example.feature_envy.easy;

public class PaymentTranslator {
    /**
     * Returns a human-readable string for the payment.
     */
    public String translate(Payment p) {
        if (p == null) return "No payment";
        return p.getAmount() + " " + p.getCurrency();
    }
}

class Payment {
    private final double amount;
    private final String currency;
    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}
