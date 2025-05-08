package org.example.god_object.medium;

public class AnalyticsDashboard {
    private Gson gson = new Gson();
    private Connection connection;

    public AnalyticsDashboard() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateUserReport() {
        List<String> users = fetchUsers();
        Map<String, Integer> data = analyze(users);
        return gson.toJson(data);
    }

    private List<String> fetchUsers() {
        List<String> list = new ArrayList<>();
        try (ResultSet rs = connection.createStatement().executeQuery("SELECT NAME FROM CUSTOMERS")) {
            while (rs.next()) list.add(rs.getString("NAME"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Map<String, Integer> analyze(List<String> users) {
        Map<String, Integer> counts = new HashMap<>();
        for (String u : users) counts.put(u, counts.getOrDefault(u, 0) + 1);
        return counts;
    }
}
