package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountApplierTest {
    @Test
    void testApplyDiscountPremium() {
        DiscountApplier da = new DiscountApplier();
        assertEquals(90.0, da.applyDiscount("PREMIUM", 100.0));
    }

    @Test
    void testApplyDiscountNone() {
        DiscountApplier da = new DiscountApplier();
        assertEquals(100.0, da.applyDiscount("UNKNOWN", 100.0));
    }
}
