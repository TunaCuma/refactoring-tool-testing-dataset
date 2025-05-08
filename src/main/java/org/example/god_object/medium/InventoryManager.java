package org.example.god_object.medium;

public class InventoryManager {
    private Map<String, Integer> stock = new HashMap<>();
    private Connection connection;

    public InventoryManager() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProduct(String sku, int quantity) {
        if (sku == null || sku.isBlank() || quantity <= 0) throw new IllegalArgumentException();
        stock.put(sku, stock.getOrDefault(sku, 0) + quantity);
        updateDatabase(sku, stock.get(sku));
        if (stock.get(sku) < 5) sendRestockAlert(sku);
    }

    public int getStock(String sku) {
        return stock.getOrDefault(sku, 0);
    }

    private void updateDatabase(String sku, int qty) {
        try (PreparedStatement ps = connection.prepareStatement(
                "MERGE INTO INVENTORY(SKU,QT) KEY(SKU) VALUES(?,?)")) {
            ps.setString(1, sku);
            ps.setInt(2, qty);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendRestockAlert(String sku) {
        System.out.println("Alert: Low stock for " + sku);
    }
}
