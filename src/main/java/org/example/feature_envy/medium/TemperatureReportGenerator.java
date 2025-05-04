package org.example.feature_envy.medium;

public class TemperatureReportGenerator {
    /**
     * Generates temperature range report from weather data.
     */
    public String report(WeatherData wd) {
        if (wd == null || wd.getTemps().length == 0) return "No temperatures";
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for (double t : wd.getTemps()) {
            if (t < min) min = t;
            if (t > max) max = t;
        }
        return String.format("Low: %.1f, High: %.1f", min, max);
    }
}

class WeatherData {
    private final double[] temps;
    public WeatherData(double[] temps) { this.temps = temps; }
    public double[] getTemps() { return temps; }
}
