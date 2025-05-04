package org.example.feature_envy.easy;

public class TemperatureConverter {
    /**
     * Converts a weather's Celsius temp to Fahrenheit.
     */
    public double toFahrenheit(Weather w) {
        if (w == null) return Double.NaN;
        return w.getCelsius() * 9/5 + 32;
    }
}

class Weather {
    private final double celsius;
    public Weather(double celsius) { this.celsius = celsius; }
    public double getCelsius() { return celsius; }
}
