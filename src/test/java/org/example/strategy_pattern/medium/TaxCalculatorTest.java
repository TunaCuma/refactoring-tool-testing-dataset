package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TaxCalculatorTest {
    @Test
    void testEuropeTax() {
        TaxCalculator tc = new TaxCalculator();
        assertEquals(25.0, tc.calculate("EU", 100));
    }
    @Test
    void testUnknownRegion() {
        TaxCalculator tc = new TaxCalculator();
        assertThrows(IllegalStateException.class, () -> tc.calculate("AFRICA", 100));
    }
}
