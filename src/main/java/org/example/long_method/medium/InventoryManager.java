package org.example.long_method.medium;

public class InventoryManager {
    /**
     * Processes shipments, sales, returns, reorders, and low-stock alerts.
     */
    public java.util.List<String> manageInventory(java.util.Map<String,Integer> stock,
            java.util.List<java.util.Map<String,Object>> events) {
        java.util.List<String> alerts = new java.util.ArrayList<>();
        for (var e : events) {
            String type = (String)e.get("type");
            String item = (String)e.get("item");
            int qty = (Integer)e.getOrDefault("qty", 0);
            if ("shipment".equalsIgnoreCase(type)) {
                stock.put(item, stock.getOrDefault(item, 0) + qty);
            } else if ("sale".equalsIgnoreCase(type)) {
                stock.put(item, stock.getOrDefault(item, 0) - qty);
            } else if ("return".equalsIgnoreCase(type)) {
                stock.put(item, stock.getOrDefault(item, 0) + qty);
            }
            if (stock.getOrDefault(item, 0) < 5) {
                alerts.add("Low stock: " + item + "=" + stock.get(item));
            }
        }
        return alerts;
    }
}
