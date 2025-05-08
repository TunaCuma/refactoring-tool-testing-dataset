package org.example.god_object.medium;

public class ShipmentController {
    private Connection connection;

    public ShipmentController() {
        try { connection = DriverManager.getConnection("jdbc:h2:mem:testdb"); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public void shipOrder(int orderId, String address) {
        if (orderId <= 0 || address.isBlank()) throw new IllegalArgumentException();
        createShippingLabel(orderId, address);
        updateShipmentStatus(orderId);
        notifyCustomer(orderId);
    }

    private void createShippingLabel(int id, String addr) {
        System.out.println("Label created for " + id + " to " + addr);
    }

    private void updateShipmentStatus(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO SHIPMENTS(ID,STATUS) VALUES(?, 'SHIPPED')")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void notifyCustomer(int id) {
        System.out.println("Customer notified for shipment " + id);
    }
}
