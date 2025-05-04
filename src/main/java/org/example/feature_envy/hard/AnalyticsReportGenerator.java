package org.example.feature_envy.hard;

import java.util.*;

public class AnalyticsReportGenerator {
    /**
     * Generates report of min, max, avg for each metric.
     */
    public String generateReport(AnalyticsData data) {
        if (data == null || data.getMetrics() == null || data.getMetrics().isEmpty()) {
            return "No analytics data";
        }
        StringBuilder sb = new StringBuilder("Analytics Report:\n");
        for (Map.Entry<String, List<Integer>> entry : data.getMetrics().entrySet()) {
            String name = entry.getKey();
            List<Integer> values = entry.getValue();
            if (values == null || values.isEmpty()) continue;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
            for (int v : values) {
                if (v < min) min = v;
                if (v > max) max = v;
                sum += v;
            }
            double avg = sum / (double) values.size();
            sb.append(name)
              .append(": min=").append(min)
              .append(", max=").append(max)
              .append(", avg=").append(String.format("%.2f", avg))
              .append("\n");
        }
        return sb.toString().trim();
    }
}

class AnalyticsData {
    private final Map<String, List<Integer>> metrics;
    public AnalyticsData(Map<String, List<Integer>> metrics) {
        this.metrics = metrics;
    }
    public Map<String, List<Integer>> getMetrics() { return metrics; }
}
