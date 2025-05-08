package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ShipmentControllerTest {
    @Test
    void testShipOrderValid() {
        ShipmentController sc = new ShipmentController();
        assertDoesNotThrow(() -> sc.shipOrder(1, "123 Main St"));
    }

    @Test
    void testShipOrderInvalid() {
        ShipmentController sc = new ShipmentController();
        assertThrows(IllegalArgumentException.class, () -> sc.shipOrder(0, ""));
    }
}
