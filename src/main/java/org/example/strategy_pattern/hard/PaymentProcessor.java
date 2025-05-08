package org.example.strategy_pattern.hard;

public class PaymentProcessor {
    public void processPayment(String type, double amount) {
        if (type.equals("CREDIT_CARD")) {
            // authenticate
            System.out.println("Authenticating credit card");
            // charge
            System.out.println("Charging credit card: " + amount);
            // send receipt
            System.out.println("Sending credit card receipt");
        } else if (type.equals("PAYPAL")) {
            System.out.println("Logging into PayPal");
            System.out.println("Transferring via PayPal: " + amount);
            System.out.println("Emailing PayPal receipt");
        } else if (type.equals("BITCOIN")) {
            System.out.println("Connecting to Bitcoin network");
            System.out.println("Transferring BTC: " + amount);
            System.out.println("Generating blockchain receipt");
        } else {
            System.out.println("Unsupported payment type: " + type);
        }
    }
}
