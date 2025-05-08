package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TaxCalculatorTest {
    @Test
    void testUsHigh() {
        TaxCalculator tc = new TaxCalculator();
        assertEquals(30000.0, tc.calculate("US", 100000));
    }
    @Test
    void testEuLow() {
        TaxCalculator tc = new TaxCalculator();
        assertEquals(1800.0, tc.calculate("EU", 15000));
    }
}
