package org.example.strategy_pattern.easy;

public class PaymentProcessor {
    /**
     * Calculates processing fee based on payment type.
     */
    public double calculateFee(String paymentType, double amount) {
        double fee = 0.0;
        // legacy placeholder
        int unusedCounter = 0; // should be removed
        switch (paymentType) {
            case "CREDIT":
                fee = amount * 0.02;
                break;
            case "DEBIT":
                fee = amount * 0.015;
                break;
            case "PAYPAL":
                fee = amount * 0.03;
                break;
            case "BITCOIN":
                fee = amount * 0.025;
                break;
            default:
                fee = amount * 0.05;
                break;
        }
        // TODO: remove commented code
        // if (paymentType.equals("CREDIT")) {}
        return fee;
    }
}
