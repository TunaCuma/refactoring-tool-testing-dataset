package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class InventoryReportFormatterTest {
    @Test
    void testFormatReport() {
        List<Item> items = Arrays.asList(
            new Item("Widget", 5, 10),
            new Item("Gadget", 20, 15)
        );
        Inventory inv = new Inventory(items);
        String res = new InventoryReportFormatter().formatReport(inv);
        assertTrue(res.contains("Widget - Stock: 5 [REORDER]"));
        assertTrue(res.contains("Gadget - Stock: 20"));
    }
    @Test
    void testFormatEmpty() {
        assertEquals("No inventory", new InventoryReportFormatter().formatReport(null));
        assertEquals("No inventory", new InventoryReportFormatter().formatReport(new Inventory(null)));
    }
}
