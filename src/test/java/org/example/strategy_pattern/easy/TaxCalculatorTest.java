package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    @Test
    void testCalculateUs() {
        TaxCalculator tc = new TaxCalculator();
        assertEquals(30.0, tc.calculate(100.0, "US"));
    }

    @Test
    void testCalculateDefault() {
        TaxCalculator tc = new TaxCalculator();
        assertEquals(35.0, tc.calculate(100.0, "UNKNOWN"));
    }
}
