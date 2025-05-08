package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountServiceTest {
    @Test
    void testGoldDiscount() {
        DiscountService ds = new DiscountService();
        assertEquals(90.0, ds.applyDiscount("GOLD", 100));
    }
    @Test
    void testNoDiscount() {
        DiscountService ds = new DiscountService();
        assertEquals(100.0, ds.applyDiscount("UNKNOWN", 100));
    }
}
