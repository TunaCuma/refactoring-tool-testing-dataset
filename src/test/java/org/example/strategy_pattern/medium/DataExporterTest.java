package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DataExporterTest {
    @Test
    void testCsvExport() {
        DataExporter exp = new DataExporter();
        assertEquals("csv:data", exp.export("CSV", "data"));
    }
    @Test
    void testUnsupportedExport() {
        DataExporter exp = new DataExporter();
        assertThrows(IllegalArgumentException.class, () -> exp.export("YAML", "data"));
    }
}
