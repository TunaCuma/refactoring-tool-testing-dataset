package org.example.god_object.medium;

public class ProductCatalog {
    private List<String> products = new ArrayList<>();
    private Connection connection;

    public ProductCatalog() {
        try { connection = DriverManager.getConnection("jdbc:h2:mem:testdb"); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public void loadProducts() {
        products.clear();
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT NAME FROM PRODUCTS")) {
            while (rs.next()) products.add(rs.getString("NAME"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<String> search(String keyword) {
        List<String> res = new ArrayList<>();
        for (String p : products) if (p.contains(keyword)) res.add(p);
        return res;
    }
}
