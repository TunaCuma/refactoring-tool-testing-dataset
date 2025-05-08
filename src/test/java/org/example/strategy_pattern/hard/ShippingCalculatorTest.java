package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ShippingCalculatorTest {
    @Test
    void testDomesticUnder5() {
        ShippingCalculator calc = new ShippingCalculator();
        assertEquals(5.0, calc.calculate("DOMESTIC", 3.0));
    }
    @Test
    void testExpressOver20() {
        ShippingCalculator calc = new ShippingCalculator();
        assertEquals(100.0, calc.calculate("EXPRESS", 25.0));
    }
}
