package org.example.feature_envy.easy;

public class AccountReporter {
    /**
     * Generates a summary report string for the account.
     */
    public String generateReport(Account account) {
        if (account == null) return "No account";
        return String.format("Account %s has balance %.2f", account.getId(), account.getBalance());
    }
}

class Account {
    private final String id;
    private final double balance;
    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }
    public String getId() { return id; }
    public double getBalance() { return balance; }
}
