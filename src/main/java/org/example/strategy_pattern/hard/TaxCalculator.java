package org.example.strategy_pattern.hard;

public class TaxCalculator {
    public double calculate(String region, double income) {
        if (region.equals("US")) {
            if (income < 10000) return income * 0.1;
            else if (income < 50000) return income * 0.2;
            else return income * 0.3;
        } else if (region.equals("EU")) {
            if (income < 15000) return income * 0.12;
            else if (income < 60000) return income * 0.22;
            else return income * 0.32;
        }
        return 0;
    }
}
