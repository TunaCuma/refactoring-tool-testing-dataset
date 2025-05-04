package org.example.feature_envy.hard;

import java.util.*;

public class LoyaltyPointsCalculator {
    /**
     * Calculates loyalty points based on activities.
     */
    public int calculatePoints(LoyaltyAccount account) {
        if (account == null || account.getActivities() == null) return 0;
        int points = 0;
        for (Activity a : account.getActivities()) {
            if (a == null) continue;
            switch (a.getType()) {
                case "purchase":
                    points += a.getValue();
                    break;
                case "review":
                    points += 10;
                    break;
                case "referral":
                    points += 50;
                    break;
                default:
                    points += 1;
            }
        }
        return points;
    }
}

class LoyaltyAccount {
    private final List<Activity> activities;
    public LoyaltyAccount(List<Activity> activities) {
        this.activities = activities;
    }
    public List<Activity> getActivities() { return activities; }
}

class Activity {
    private final String type;
    private final int value;
    public Activity(String type, int value) {
        this.type = type; this.value = value;
    }
    public String getType() { return type; }
    public int getValue() { return value; }
}
