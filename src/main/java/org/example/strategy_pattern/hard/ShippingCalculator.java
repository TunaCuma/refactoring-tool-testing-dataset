package org.example.strategy_pattern.hard;

public class ShippingCalculator {
    public double calculate(String region, double weight) {
        if (region.equals("DOMESTIC")) {
            if (weight < 5) return 5.0;
            else if (weight < 20) return 10.0;
            else return 20.0;
        } else if (region.equals("INTERNATIONAL")) {
            if (weight < 5) return 15.0;
            else if (weight < 20) return 30.0;
            else return 50.0;
        } else if (region.equals("EXPRESS")) {
            if (weight < 5) return 25.0;
            else if (weight < 20) return 50.0;
            else return 100.0;
        }
        return -1;
    }
}
