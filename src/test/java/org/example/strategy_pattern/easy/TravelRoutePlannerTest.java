package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelRoutePlannerTest {
    @Test
    void testPlanFlight() {
        TravelRoutePlanner trp = new TravelRoutePlanner();
        assertEquals("Flying to Paris", trp.plan("FLIGHT", "Paris"));
    }

    @Test
    void testPlanDefault() {
        TravelRoutePlanner trp = new TravelRoutePlanner();
        assertEquals("Walking to Paris", trp.plan("BIKE", "Paris"));
    }
}
