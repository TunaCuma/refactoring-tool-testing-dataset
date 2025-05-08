package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ReportFormatterTest {
    @Test
    void testJsonFormat() {
        ReportFormatter fmt = new ReportFormatter();
        assertEquals("{ \"report\": \"data\" }", fmt.formatReport("JSON", "data"));
    }
    @Test
    void testPlainFormat() {
        ReportFormatter fmt = new ReportFormatter();
        assertEquals("plain", fmt.formatReport("PLAINTEXT", "plain"));
    }
}
