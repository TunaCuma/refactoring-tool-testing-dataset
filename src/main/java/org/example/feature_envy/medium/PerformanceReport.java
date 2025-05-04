package org.example.feature_envy.medium;

public class PerformanceReport {
    /**
     * Generates performance summary for an employee.
     */
    public String generate(EmployeePerformance ep) {
        if (ep == null || ep.getScores().length == 0) return "No performance data";
        double sum = 0;
        for (double s : ep.getScores()) sum += s;
        double avg = sum / ep.getScores().length;
        String rating = avg >= 80 ? "Good" : "Needs Improvement";
        return String.format("Avg: %.1f, Rating: %s", avg, rating);
    }
}

class EmployeePerformance {
    private final double[] scores;
    public EmployeePerformance(double[] scores) { this.scores = scores; }
    public double[] getScores() { return scores; }
}
