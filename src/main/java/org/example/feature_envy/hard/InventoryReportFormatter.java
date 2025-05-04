package org.example.feature_envy.hard;

import java.util.*;

public class InventoryReportFormatter {
    /**
     * Formats inventory report with reorder flags.
     */
    public String formatReport(Inventory inv) {
        if (inv == null || inv.getItems() == null) {
            return "No inventory";
        }
        StringBuilder sb = new StringBuilder("Inventory Report:\n");
        for (Item item : inv.getItems()) {
            sb.append(item.getName())
              .append(" - Stock: ").append(item.getStock());
            if (item.getStock() < item.getReorderLevel()) {
                sb.append(" [REORDER]");
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}

class Inventory {
    private final List<Item> items;
    public Inventory(List<Item> items) { this.items = items; }
    public List<Item> getItems() { return items; }
}

class Item {
    private final String name;
    private final int stock;
    private final int reorderLevel;
    public Item(String name, int stock, int reorderLevel) {
        this.name = name; this.stock = stock; this.reorderLevel = reorderLevel;
    }
    public String getName() { return name; }
    public int getStock() { return stock; }
    public int getReorderLevel() { return reorderLevel; }
}
