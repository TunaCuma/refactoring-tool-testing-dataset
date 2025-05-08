package org.example.god_object.medium;

public class PaymentProcessor {
    private Connection connection;
    private Gson gson = new Gson();

    public PaymentProcessor() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    public String process(double amount, String method) {
        if (amount <= 0) throw new IllegalArgumentException();
        String txn = recordTransaction(amount, method);
        return gson.toJson(Map.of("status", "ok", "txn", txn));
    }

    private String recordTransaction(double amt, String m) {
        String id = UUID.randomUUID().toString();
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO TRANSACTIONS(ID,AMT,METHOD) VALUES(?,?,?)")) {
            ps.setString(1, id);
            ps.setDouble(2, amt);
            ps.setString(3, m);
            ps.execute();
        } catch (SQLException e) { e.printStackTrace(); }
        return id;
    }
}
