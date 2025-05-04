package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StringStatisticsTest {
    @Test
    public void testGenerateReport() {
        StringStatistics stats = new StringStatistics();
        List<String> inputs = Arrays.asList("apple", "banana", "kiwi", "pear");
        String report = stats.generateReport(inputs);

        assertTrue(report.contains("Count: 4"));
        assertTrue(report.contains("Total Length: 20"));
        assertTrue(report.contains("Average Length: 5.00"));
        assertTrue(report.contains("Longest: banana"));
        assertTrue(report.contains("Shortest: kiwi"));
        assertTrue(report.contains("apple"));
        assertTrue(report.contains("pear"));
    }
}
