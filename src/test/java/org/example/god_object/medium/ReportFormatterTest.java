package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReportFormatterTest {
    @Test
    void testFormatMonthlyReportEmpty() {
        ReportFormatter rf = new ReportFormatter();
        String csv = rf.formatMonthlyReport(1);
        assertTrue(csv.startsWith("Name,Value"));
    }

    @Test
    void testFormatMonthlyReportInvalidMonth() {
        ReportFormatter rf = new ReportFormatter();
        assertThrows(IllegalArgumentException.class, () -> rf.formatMonthlyReport(13));
    }
}
