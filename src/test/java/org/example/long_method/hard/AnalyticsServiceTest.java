package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.util.*;
class AnalyticsServiceTest {
    @Test
    void testRunAnalytics(tmpdir: Path) throws Exception {
        Path f = tmpdir.resolve("data.csv");
        Files.writeString(f, "1,10.5,1000\n2,5.0,2000\n3,-1,3000\n4,abc,4000\n");
        Map<Integer,String> ref = Map.of(1,"A",2,"B");
        String report = new AnalyticsService().runAnalytics(f.toString(), ref);
        assertTrue(report.contains("Total Value: 15.5"));
        assertTrue(report.contains("A: 10.5"));
    }
    @Test
    void testInvalidPath() {
        String out = new AnalyticsService().runAnalytics("nope", Collections.emptyMap());
        assertTrue(out.startsWith("Failed to load data:"));
    }
}
