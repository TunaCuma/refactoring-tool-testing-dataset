package org.example.feature_envy.easy;

public class StatCalculator {
    /**
     * Computes average of student scores.
     */
    public double average(Student s) {
        if (s == null) return 0.0;
        double sum = 0;
        for (double sc : s.getScores()) sum += sc;
        return sum / s.getScores().length;
    }
}

class Student {
    private final double[] scores;
    public Student(double[] scores) { this.scores = scores; }
    public double[] getScores() { return scores; }
}
