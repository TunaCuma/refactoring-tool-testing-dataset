package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DistanceFormatterTest {
    @Test
    void testFormatDistance() {
        Location loc = new Location(3, 4);
        assertEquals("Distance: 5.00 units", new DistanceFormatter().formatDistance(loc));
    }
    @Test
    void testFormatDistanceNull() {
        assertEquals("No location", new DistanceFormatter().formatDistance(null));
    }
}
