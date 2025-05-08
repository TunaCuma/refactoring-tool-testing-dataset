package org.example.strategy_pattern.medium;

public class TaxCalculator {
    public double calculate(String region, double income) {
        if ("US".equals(region)) {
            return income * 0.30;
        } else if ("EU".equals(region)) {
            return income * 0.25;
        } else if ("ASIA".equals(region)) {
            return income * 0.20;
        }
        throw new IllegalStateException("Region not recognized: " + region);
    }
}
