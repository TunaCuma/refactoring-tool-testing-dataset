package org.example.god_object.easy;

public class InventoryController {
    private java.util.Map<String, Integer> stock = new java.util.HashMap<>();
    private java.util.List<String> notifications = new java.util.ArrayList<>();

    public void addItem(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item, int quantity) {
        int current = stock.getOrDefault(item, 0);
        if (current < quantity) {
            notifications.add("Insufficient stock for " + item);
        } else {
            stock.put(item, current - quantity);
        }
    }

    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }

    public void checkLowStock(int threshold) {
        for (java.util.Map.Entry<String, Integer> entry : stock.entrySet()) {
            if (entry.getValue() < threshold) {
                notifications.add("Low stock: " + entry.getKey());
            }
        }
    }

    public java.util.List<String> getNotifications() {
        return notifications;
    }
}
