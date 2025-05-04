package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PerformanceReportTest {
    @Test
    void testGenerateGood() {
        EmployeePerformance ep = new EmployeePerformance(new double[]{80, 90, 85});
        assertEquals("Avg: 85.0, Rating: Good", new PerformanceReport().generate(ep));
    }
    @Test
    void testGenerateNeedsImprovement() {
        EmployeePerformance ep = new EmployeePerformance(new double[]{60, 70});
        assertEquals("Avg: 65.0, Rating: Needs Improvement", new PerformanceReport().generate(ep));
    }
    @Test
    void testGenerateNoData() {
        assertEquals("No performance data", new PerformanceReport().generate(null));
        assertEquals("No performance data", new PerformanceReport().generate(new EmployeePerformance(new double[0])));
    }
}
