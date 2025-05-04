package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ShippingCostCalculatorTest {
    @Test
    void testCalculateCostNonFragile() {
        Order o = new Order(2.0, 100.0, 0.5, false);
        assertEquals(2.0 * 100.0 * 0.5, new ShippingCostCalculator().calculateCost(o));
    }
    @Test
    void testCalculateCostFragile() {
        Order o = new Order(1.0, 50.0, 1.0, true);
        assertEquals(1.0 * 50.0 * 1.0 + 10.0, new ShippingCostCalculator().calculateCost(o));
    }
    @Test
    void testCalculateCostNull() {
        assertEquals(0.0, new ShippingCostCalculator().calculateCost(null));
    }
}
