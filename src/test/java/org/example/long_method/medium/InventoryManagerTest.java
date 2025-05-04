package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class InventoryManagerTest {
    @Test
    void testManageEvents() {
        Map<String,Integer> stock = new HashMap<>(Map.of("x", 10));
        var shipment = new HashMap<String,Object>(Map.of("type","shipment","item","x","qty",3));
        var sale = new HashMap<String,Object>(Map.of("type","sale","item","x","qty",9));
        var alerts = new InventoryManager().manageInventory(stock, List.of(shipment, sale));
        assertTrue(alerts.contains("Low stock: x=4"));
    }
}
