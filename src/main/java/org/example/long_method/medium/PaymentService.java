package org.example.long_method.medium;

public class PaymentService {
    /**
     * Validates payment, authorizes, captures funds, and sends receipt.
     */
    public String processPayment(String cardNumber, double amount, String receiptEmail) {
        // 1. Validate inputs
        if (cardNumber == null || cardNumber.length() < 12) {
            throw new IllegalArgumentException("Invalid card number");
        }
        if (amount <= 0) {
            return "No amount to process.";
        }
        // 2. Check balance (stubbed)
        double balance = 1000.0;
        if (amount > balance) {
            return "Insufficient funds.";
        }
        // 3. Authorize
        boolean auth = cardNumber.startsWith("4");
        if (!auth) {
            return "Authorization failed.";
        }
        // 4. Capture
        String transactionId = "TXN" + System.currentTimeMillis();
        // 5. Send receipt
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction: ").append(transactionId).append("\n");
        sb.append("Amount: $").append(amount).append("\n");
        if (receiptEmail != null && receiptEmail.contains("@")) {
            sb.append("Receipt sent to: ").append(receiptEmail);
        } else {
            sb.append("No receipt email provided.");
        }
        return sb.toString();
    }
}
