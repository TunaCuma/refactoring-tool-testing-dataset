package org.example.strategy_pattern.easy;

public class TravelRoutePlanner {
    /**
     * Plans route based on transportation mode.
     */
    public String plan(String mode, String destination) {
        if (mode.equals("CAR")) {
            return "Driving to " + destination;
        } else if (mode.equals("TRAIN")) {
            return "Taking train to " + destination;
        } else if (mode.equals("FLIGHT")) {
            return "Flying to " + destination;
        }
        return "Walking to " + destination;
    }
}
