package org.example.strategy_pattern.easy;

public class TaxCalculator {
    /**
     * Calculates tax based on region.
     */
    public double calculate(double income, String region) {
        double tax;
        switch (region) {
            case "US":
                tax = income * 0.30;
                break;
            case "EU":
                tax = income * 0.25;
                break;
            case "ASIA":
                tax = income * 0.20;
                break;
            default:
                tax = income * 0.35;
                break;
        }
        return tax;
    }
}
