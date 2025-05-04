package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class LogAnalyzerTest {
    @Test
    void testAnalyzeLogs() {
        LogAnalyzer la = new LogAnalyzer();
        List<String> logs = Arrays.asList("INFO start","WARN disk","ERROR crash","INFO end");
        String res = la.analyze(logs);
        assertTrue(res.contains("INFO: 2"));
        assertTrue(res.contains("WARN: 1"));
        assertTrue(res.contains("ERROR: 1"));
    }

    @Test
    void testAnalyzeNull() {
        LogAnalyzer la = new LogAnalyzer();
        assertEquals("No logs provided.", la.analyze(null));
    }
}
