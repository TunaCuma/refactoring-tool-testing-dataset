package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PromotionEngineTest {
    @Test
    void testWinter() {
        PromotionEngine pe = new PromotionEngine();
        assertEquals(85.0, pe.applyPromotion("WINTER", 100.0));
    }
    @Test
    void testUnknown() {
        PromotionEngine pe = new PromotionEngine();
        assertEquals(100.0, pe.applyPromotion("UNKNOWN", 100.0));
    }
}
