package org.example.long_method.medium;

public class OrderFulfillment {
    /**
     * Checks inventory, reserves items, calculates shipping, packages, and updates status.
     */
    public String fulfillOrder(String orderId, java.util.Map<String,Integer> inventory, java.util.Map<String,Integer> order) {
        // 1. Validate
        if (orderId == null || orderId.isEmpty()) return "Invalid order ID.";
        if (order == null || order.isEmpty()) return "Nothing to fulfill.";
        // 2. Check inventory
        for (var item : order.entrySet()) {
            int have = inventory.getOrDefault(item.getKey(), 0);
            if (have < item.getValue()) {
                return "Out of stock: " + item.getKey();
            }
        }
        // 3. Reserve
        for (var item : order.entrySet()) {
            inventory.put(item.getKey(), inventory.get(item.getKey()) - item.getValue());
        }
        // 4. Calculate shipping
        double weight = order.values().stream().mapToInt(i -> i).sum() * 0.5;
        double cost = weight * 2.0;
        // 5. Package
        String packageId = "PKG" + orderId;
        // 6. Update status
        return String.format("Order %s fulfilled, shipping=%.2f, package=%s", orderId, cost, packageId);
    }
}
