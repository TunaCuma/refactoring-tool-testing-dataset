package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
class OrderProcessorTest {
    @Test
    void testProcessOrderValid() {
        OrderProcessor op = new OrderProcessor();
        String summary = op.processOrder("Alice", Arrays.asList(10.0, 20.0, 30.0), 0.1);
        assertTrue(summary.contains("Subtotal: $60.00"));
        assertTrue(summary.contains("Discount: $6.00"));
        assertTrue(summary.contains("Total: $54.00"));
    }

    @Test
    void testProcessOrderNoPrices() {
        OrderProcessor op = new OrderProcessor();
        assertEquals("No items to process for Bob", op.processOrder("Bob", java.util.Collections.emptyList(), 0.2));
    }
}
