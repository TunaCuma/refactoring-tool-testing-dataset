package org.example.feature_envy.hard;

import java.util.*;

public class TaxCalculator {
    /**
     * Calculates tax based on income and tax brackets.
     */
    public double calculateTax(TaxInfo info) {
        if (info == null || info.getBrackets() == null) return 0.0;
        double income = info.getIncome();
        double tax = 0.0;
        double remaining = income;
        for (TaxBracket b : info.getBrackets()) {
            if (remaining <= 0) break;
            double taxable = Math.min(remaining, b.getThreshold());
            tax += taxable * b.getRate();
            remaining -= taxable;
        }
        return tax;
    }
}

class TaxInfo {
    private final double income;
    private final List<TaxBracket> brackets;
    public TaxInfo(double income, List<TaxBracket> brackets) {
        this.income = income; this.brackets = brackets;
    }
    public double getIncome() { return income; }
    public List<TaxBracket> getBrackets() { return brackets; }
}

class TaxBracket {
    private final double threshold;
    private final double rate;
    public TaxBracket(double threshold, double rate) {
        this.threshold = threshold; this.rate = rate;
    }
    public double getThreshold() { return threshold; }
    public double getRate() { return rate; }
}
