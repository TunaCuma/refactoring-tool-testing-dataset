package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TravelItineraryPrinterTest {
    @Test
    void testPrintWithLayover() {
        Flight f1 = new Flight("NYC","LAX",6.0,null);
        Flight f2 = new Flight("LAX","SFO",1.5,0.5);
        Itinerary iti = new Itinerary(Arrays.asList(f1,f2));
        String res = new TravelItineraryPrinter().printItinerary(iti);
        assertTrue(res.contains("NYC->LAX (6.0h)"));
        assertTrue(res.contains("LAX->SFO (1.5h) Layover: 0.5h"));
    }
    @Test
    void testPrintEmpty() {
        assertEquals("No itinerary",
            new TravelItineraryPrinter().printItinerary(null));
        assertEquals("No itinerary",
            new TravelItineraryPrinter().printItinerary(new Itinerary(null)));
    }
}
