package org.example.feature_envy.medium;

import java.util.List;
public class ShoppingCartAnalyzer {
    /**
     * Calculates total price and item count from a cart.
     */
    public String analyze(Cart cart) {
        if (cart == null || cart.getItems().isEmpty()) return "Empty cart";
        int itemCount = 0;
        double total = 0.0;
        for (CartItem it : cart.getItems()) {
            itemCount += it.getQuantity();
            total += it.getPrice() * it.getQuantity();
        }
        return String.format("Items: %d, Total: %.2f", itemCount, total);
    }
}

class Cart {
    private final List<CartItem> items;
    public Cart(List<CartItem> items) { this.items = items; }
    public List<CartItem> getItems() { return items; }
}

class CartItem {
    private final String name;
    private final double price;
    private final int quantity;
    public CartItem(String name, double price, int quantity) {
        this.name = name; this.price = price; this.quantity = quantity;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
