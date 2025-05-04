package org.example.feature_envy.medium;

public class WorkHoursCalculator {
    /**
     * Calculates total work hours from a timesheet.
     */
    public int totalHours(Timesheet t) {
        if (t == null || t.getDailyHours().length == 0) return 0;
        int sum = 0;
        for (int h : t.getDailyHours()) {
            if (h > 8) sum += 8;
            else sum += h;
        }
        return sum;
    }
}

class Timesheet {
    private final int[] dailyHours;
    public Timesheet(int[] dailyHours) { this.dailyHours = dailyHours; }
    public int[] getDailyHours() { return dailyHours; }
}
