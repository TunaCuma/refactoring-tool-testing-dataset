package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InventoryControllerTest {
    @Test
    void testAddAndGetStock() {
        InventoryController ic = new InventoryController();
        ic.addItem("apple", 10);
        assertEquals(10, ic.getStock("apple"));
    }
    @Test
    void testRemoveAndNotify() {
        InventoryController ic = new InventoryController();
        ic.addItem("banana", 5);
        ic.removeItem("banana", 10);
        assertTrue(ic.getNotifications().contains("Insufficient stock for banana"));
    }
}
