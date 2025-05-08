package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ShippingCalculatorTest {
    @Test
    void testStandardShipping() {
        ShippingCalculator calc = new ShippingCalculator();
        assertEquals(10.0, calc.calculateShipping("STANDARD", 10));
    }
    @Test
    void testUnknownShippingType() {
        ShippingCalculator calc = new ShippingCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.calculateShipping("UNKNOWN", 5));
    }
}
