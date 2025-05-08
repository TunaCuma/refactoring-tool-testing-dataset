package org.example.god_object.medium;

public class CustomerManager {
    private List<String> customers = new ArrayList<>();
    private Connection connection;

    public CustomerManager() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Invalid name");
        customers.add(name);
        saveToDatabase(name);
        sendWelcomeEmail(name);
    }

    public int getCustomerCount() {
        return customers.size();
    }

    private void saveToDatabase(String name) {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("INSERT INTO CUSTOMERS(NAME) VALUES('" + name + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendWelcomeEmail(String name) {
        System.out.println("Welcome email sent to " + name);
    }
}
