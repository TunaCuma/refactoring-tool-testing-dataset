package org.example.long_method.medium;

public class MetricsCalculator {
    /**
     * Calculates multiple site metrics: sessions, bounce rate, conversion, etc.
     */
    public java.util.Map<String, Double> calculateAllMetrics(java.util.List<java.util.Map<String, Object>> visits) {
        java.util.Map<String, Double> metrics = new java.util.HashMap<>();
        if (visits == null || visits.isEmpty()) {
            return metrics;
        }
        int sessions = visits.size();
        int bounces = 0;
        int conversions = 0;
        for (var v : visits) {
            Boolean bounce = (Boolean)v.getOrDefault("bounce", false);
            Boolean conv = (Boolean)v.getOrDefault("conversion", false);
            if (bounce) bounces++;
            if (conv) conversions++;
        }
        double bounceRate = (double)bounces / sessions;
        double convRate = (double)conversions / sessions;
        metrics.put("sessions", (double)sessions);
        metrics.put("bounceRate", bounceRate);
        metrics.put("conversionRate", convRate);
        return metrics;
    }
}
