package org.example.god_object.easy;

public class PaymentHandler {
    private java.util.Map<String, String> payments = new java.util.HashMap<>();

    public String initiatePayment(String account, double amount) {
        String id = java.util.UUID.randomUUID().toString();
        payments.put(id, "PENDING");
        return id;
    }

    public boolean validatePayment(String paymentId) {
        String status = payments.get(paymentId);
        if ("PENDING".equals(status)) {
            payments.put(paymentId, "COMPLETED");
            return true;
        }
        return false;
    }

    public boolean refund(String paymentId) {
        if ("COMPLETED".equals(payments.get(paymentId))) {
            payments.put(paymentId, "REFUNDED");
            return true;
        }
        return false;
    }

    public String getPaymentStatus(String paymentId) {
        return payments.getOrDefault(paymentId, "UNKNOWN");
    }
}
