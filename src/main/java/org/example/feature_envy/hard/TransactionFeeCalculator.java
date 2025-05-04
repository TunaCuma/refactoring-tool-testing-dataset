package org.example.feature_envy.hard;

import java.util.*;

public class TransactionFeeCalculator {
    /**
     * Calculates total fees for a batch of transactions.
     */
    public double calculateFees(TransactionBatch batch) {
        if (batch == null || batch.getTransactions() == null) return 0.0;
        double totalFee = 0.0;
        for (Transaction t : batch.getTransactions()) {
            if (t == null) continue;
            double amt = t.getAmount();
            String type = t.getType();
            if ("withdrawal".equals(type)) {
                totalFee += amt * 0.025;
            } else if ("deposit".equals(type)) {
                totalFee += amt * 0.01;
            } else {
                totalFee += amt * 0.05;
            }
        }
        return totalFee;
    }
}

class TransactionBatch {
    private final List<Transaction> transactions;
    public TransactionBatch(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    public List<Transaction> getTransactions() { return transactions; }
}

class Transaction {
    private final double amount;
    private final String type;
    public Transaction(double amount, String type) {
        this.amount = amount; this.type = type;
    }
    public double getAmount() { return amount; }
    public String getType() { return type; }
}
