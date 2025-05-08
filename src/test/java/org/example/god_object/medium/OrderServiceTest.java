package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OrderServiceTest {
    @Test
    void testPlaceOrderValid() {
        OrderService svc = new OrderService();
        svc.placeOrder(1, 100.0);
        assertEquals(100.0, svc.getTotalRevenue());
    }

    @Test
    void testPlaceOrderInvalid() {
        OrderService svc = new OrderService();
        assertThrows(IllegalArgumentException.class, () -> svc.placeOrder(0, -5));
    }
}
