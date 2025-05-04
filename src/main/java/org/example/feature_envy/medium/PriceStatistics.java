package org.example.feature_envy.medium;

public class PriceStatistics {
    /**
     * Calculates min, max, and average prices from a catalog.
     */
    public String summarize(Catalog catalog) {
        if (catalog == null || catalog.getPrices().length == 0) return "No data";
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, sum = 0;
        for (double p : catalog.getPrices()) {
            if (p < min) min = p;
            if (p > max) max = p;
            sum += p;
        }
        double avg = sum / catalog.getPrices().length;
        return String.format("min=%.2f,max=%.2f,avg=%.2f", min, max, avg);
    }
}

class Catalog {
    private final double[] prices;
    public Catalog(double[] prices) { this.prices = prices; }
    public double[] getPrices() { return prices; }
}
