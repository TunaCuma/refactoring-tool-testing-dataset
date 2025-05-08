package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountServiceTest {
    @Test
    void testStudent() {
        DiscountService ds = new DiscountService();
        assertEquals(80.0, ds.applyDiscount("STUDENT", 100.0));
    }
    @Test
    void testNone() {
        DiscountService ds = new DiscountService();
        assertEquals(100.0, ds.applyDiscount("NONE", 100.0));
    }
}
