package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OrderEvaluatorTest {
    @Test
    void testIsLargeOrderTrue() {
        Order o = new Order(50, 25.0);
        assertTrue(new OrderEvaluator().isLargeOrder(o));
    }
    @Test
    void testIsLargeOrderFalse() {
        Order o = new Order(10, 20.0);
        assertFalse(new OrderEvaluator().isLargeOrder(o));
    }
}
