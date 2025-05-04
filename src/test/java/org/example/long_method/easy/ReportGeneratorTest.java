package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReportGeneratorTest {
    @Test
    void testGenerateReportWithItems() {
        ReportGenerator gen = new ReportGenerator();
        String[] input = {"apple", "banana", "apple", "orange", null};
        String report = gen.generateReport(input);
        assertTrue(report.contains("apple: 2"));
        assertTrue(report.contains("banana: 1"));
        assertTrue(report.contains("orange: 1"));
        assertTrue(report.contains("Total items: 4"));
    }

    @Test
    void testGenerateReportEmpty() {
        ReportGenerator gen = new ReportGenerator();
        assertEquals("No items to report.", gen.generateReport(new String[0]));
    }
}
