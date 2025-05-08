package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InventoryManagerTest {
    @Test
    void testAddProductNormal() {
        InventoryManager inv = new InventoryManager();
        inv.addProduct("SKU1", 10);
        assertEquals(10, inv.getStock("SKU1"));
    }

    @Test
    void testAddProductInvalid() {
        InventoryManager inv = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> inv.addProduct("", 0));
    }
}
