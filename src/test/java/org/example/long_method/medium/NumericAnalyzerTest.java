package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class NumericAnalyzerTest {
    @Test
    public void testAnalyze() {
        NumericAnalyzer na = new NumericAnalyzer();
        String report = na.analyze(Arrays.asList(3, 4, 5));

        assertTrue(report.contains("Sum: 12"));
        assertTrue(report.contains("Product: 60"));
        assertTrue(report.contains("Max: 5"));
        assertTrue(report.contains("Min: 3"));
        assertTrue(report.contains("Average: 4.00"));
        assertTrue(report.contains("Primes: 2"));      // 3 and 5
        assertTrue(report.contains("Factorial(3): 6"));
    }
}
