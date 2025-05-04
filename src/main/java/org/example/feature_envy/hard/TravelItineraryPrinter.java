package org.example.feature_envy.hard;

import java.util.*;

public class TravelItineraryPrinter {
    /**
     * Prints itinerary with flight details and layovers.
     */
    public String printItinerary(Itinerary iti) {
        if (iti == null || iti.getFlights() == null) {
            return "No itinerary";
        }
        StringBuilder sb = new StringBuilder("Itinerary:\n");
        for (Flight f : iti.getFlights()) {
            sb.append(f.getDeparture()).append("->").append(f.getArrival())
              .append(" (").append(f.getDuration()).append("h)");
            if (f.hasLayover()) {
                sb.append(" Layover: ").append(f.getLayoverDuration()).append("h");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}

class Itinerary {
    private final List<Flight> flights;
    public Itinerary(List<Flight> flights) { this.flights = flights; }
    public List<Flight> getFlights() { return flights; }
}

class Flight {
    private final String departure, arrival;
    private final double duration;
    private final Double layoverDuration;
    public Flight(String departure, String arrival, double duration, Double layoverDuration) {
        this.departure = departure; this.arrival = arrival;
        this.duration = duration; this.layoverDuration = layoverDuration;
    }
    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
    public double getDuration() { return duration; }
    public boolean hasLayover() { return layoverDuration != null; }
    public double getLayoverDuration() { return layoverDuration; }
}
