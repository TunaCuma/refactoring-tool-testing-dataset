package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExportServiceTest {
    @Test
    void testExportDataPdf() {
        ExportService svc = new ExportService();
        assertTrue(svc.exportData("PDF", "data").contains("PDF"));
    }

    @Test
    void testExportDataUnsupported() {
        ExportService svc = new ExportService();
        assertTrue(svc.exportData("TXT", "data").contains("not supported"));
    }
}
