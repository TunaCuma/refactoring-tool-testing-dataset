package org.example.god_object.medium;

public class OrderService {
    private double totalRevenue = 0;
    private Connection connection;

    public OrderService() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void placeOrder(int orderId, double amount) {
        validateOrder(orderId, amount);
        processPayment(amount);
        recordOrder(orderId, amount);
        totalRevenue += amount;
        sendConfirmation(orderId);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    private void validateOrder(int id, double amt) {
        if (id <= 0 || amt <= 0) throw new IllegalArgumentException("Invalid order parameters");
    }

    private void processPayment(double amt) {
        System.out.println("Processed payment: " + amt);
    }

    private void recordOrder(int id, double amt) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO ORDERS(ID,AMOUNT) VALUES(?,?)")) {
            ps.setInt(1, id);
            ps.setDouble(2, amt);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendConfirmation(int id) {
        System.out.println("Order " + id + " confirmed.");
    }
}
