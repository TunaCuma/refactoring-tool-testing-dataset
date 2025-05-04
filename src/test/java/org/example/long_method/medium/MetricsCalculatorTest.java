package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class MetricsCalculatorTest {
    @Test
    void testCalculateMetrics() {
        var v1 = Map.of("bounce", (Object)true, "conversion", (Object)false);
        var v2 = Map.of("bounce", (Object)false, "conversion", (Object)true);
        var metrics = new MetricsCalculator().calculateAllMetrics(List.of(v1, v2));
        assertEquals(2.0, metrics.get("sessions"));
        assertEquals(0.5, metrics.get("bounceRate"));
        assertEquals(0.5, metrics.get("conversionRate"));
    }
    @Test
    void testEmptyVisits() {
        assertTrue(new MetricsCalculator().calculateAllMetrics(Collections.emptyList()).isEmpty());
    }
}
