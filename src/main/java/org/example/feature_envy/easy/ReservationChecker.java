package org.example.feature_envy.easy;

public class ReservationChecker {
    /**
     * Checks if reservation can fit requested days.
     */
    public boolean canReserve(Reservation r, int days) {
        if (r == null) return false;
        return r.getAvailableDays() >= days;
    }
}

class Reservation {
    private final int availableDays;
    public Reservation(int availableDays) { this.availableDays = availableDays; }
    public int getAvailableDays() { return availableDays; }
}
