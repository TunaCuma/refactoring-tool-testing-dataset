package org.example.feature_envy.easy;

public class DistanceFormatter {
    /**
     * Formats the distance from origin to the location.
     */
    public String formatDistance(Location loc) {
        if (loc == null) return "No location";
        double d = Math.sqrt(loc.getX()*loc.getX() + loc.getY()*loc.getY());
        return String.format("Distance: %.2f units", d);
    }
}

class Location {
    private final double x, y;
    public Location(double x, double y) { this.x = x; this.y = y; }
    public double getX() { return x; }
    public double getY() { return y; }
}
