package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReportExporterTest {
    @Test
    void testPdf() {
        ReportExporter exp = new ReportExporter();
        assertDoesNotThrow(() -> exp.export("PDF", null));
    }
    @Test
    void testUnknown() {
        ReportExporter exp = new ReportExporter();
        assertDoesNotThrow(() -> exp.export("TXT", null));
    }
}
