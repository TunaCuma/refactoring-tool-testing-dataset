package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountApplierTest {
    @Test
    void testApplyTiers() {
        DiscountApplier da = new DiscountApplier();
        assertEquals(100 - (100*0.05), da.apply(100));
        assertEquals(600 - (600*0.1) - 10, da.apply(600));
        assertEquals(1500 - (1500*0.2) - 10, da.apply(1500));
    }

    @Test
    void testApplySmall() {
        DiscountApplier da = new DiscountApplier();
        assertEquals(50, da.apply(50));
    }
}
