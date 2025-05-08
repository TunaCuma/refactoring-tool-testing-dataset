package org.example.god_object.easy;

public class AnalyticsEngine {
    private java.util.List<Double> data = new java.util.ArrayList<>();

    public void collectData(double value) {
        data.add(value);
    }

    public double analyze() {
        return data.stream().mapToDouble(d -> d).average().orElse(0);
    }

    public String generateReport() {
        double avg = analyze();
        return "Average: " + avg;
    }

    public void exportResults(String format) {
        writeLog("Export to " + format);
    }

    private java.util.List<String> logs = new java.util.ArrayList<>();
    private void writeLog(String msg) {
        logs.add(msg);
    }
    public java.util.List<String> getLogs() {
        return logs;
    }
}
