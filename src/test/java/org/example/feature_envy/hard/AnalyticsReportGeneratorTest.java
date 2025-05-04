package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class AnalyticsReportGeneratorTest {
    @Test
    void testGenerateReport() {
        Map<String, List<Integer>> m = new HashMap<>();
        m.put("visits", Arrays.asList(100, 200, 150));
        m.put("clicks", Arrays.asList(10, 20));
        AnalyticsData data = new AnalyticsData(m);
        String res = new AnalyticsReportGenerator().generateReport(data);
        assertTrue(res.contains("visits: min=100, max=200, avg=150.00"));
        assertTrue(res.contains("clicks: min=10, max=20, avg=15.00"));
    }
    @Test
    void testGenerateEmpty() {
        assertEquals("No analytics data",
            new AnalyticsReportGenerator().generateReport(null));
        assertEquals("No analytics data",
            new AnalyticsReportGenerator().generateReport(new AnalyticsData(new HashMap<>())));
    }
}
