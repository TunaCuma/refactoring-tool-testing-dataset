package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AnalyticsEngineTest {
    @Test
    void testCollectAndAnalyze() {
        AnalyticsEngine ae = new AnalyticsEngine();
        ae.collectData(10);
        ae.collectData(20);
        assertEquals(15.0, ae.analyze());
    }
    @Test
    void testGenerateAndExport() {
        AnalyticsEngine ae = new AnalyticsEngine();
        ae.collectData(5);
        String rpt = ae.generateReport();
        assertTrue(rpt.contains("Average:"));
        ae.exportResults("CSV");
        assertTrue(ae.getLogs().contains("Export to CSV"));
    }
}
