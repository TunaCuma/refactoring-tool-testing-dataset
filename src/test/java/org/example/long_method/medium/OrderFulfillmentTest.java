package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class OrderFulfillmentTest {
    @Test
    void testSuccessfulFulfill() {
        Map<String,Integer> inv = new HashMap<>(Map.of("item1", 10));
        Map<String,Integer> ord = Map.of("item1", 2);
        String res = new OrderFulfillment().fulfillOrder("123", inv, ord);
        assertTrue(res.contains("fulfilled"));
        assertEquals(8, inv.get("item1"));
    }
    @Test
    void testOutOfStock() {
        Map<String,Integer> inv = Map.of("item1", 1);
        Map<String,Integer> ord = Map.of("item1", 2);
        assertTrue(new OrderFulfillment().fulfillOrder("123", inv, ord).startsWith("Out of stock"));
    }
}
