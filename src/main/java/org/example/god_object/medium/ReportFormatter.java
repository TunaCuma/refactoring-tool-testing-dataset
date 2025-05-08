package org.example.god_object.medium;

public class ReportFormatter {
    private Connection connection;
    private Gson gson = new Gson();

    public ReportFormatter() {
        try { connection = DriverManager.getConnection("jdbc:h2:mem:testdb"); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public String formatMonthlyReport(int month) {
        validateMonth(month);
        List<Map<String, Object>> data = fetchData(month);
        String csv = convertToCSV(data);
        saveReport(csv);
        return csv;
    }

    private void validateMonth(int m) {
        if (m < 1 || m > 12) throw new IllegalArgumentException("Invalid month");
    }

    private List<Map<String, Object>> fetchData(int month) {
        List<Map<String, Object>> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT NAME,VALUE FROM REPORTS WHERE MONTH=" + month)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("name", rs.getString("NAME"));
                row.put("value", rs.getInt("VALUE"));
                list.add(row);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    private String convertToCSV(List<Map<String, Object>> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name,Value\n");
        for (Map<String, Object> row : data) {
            sb.append(row.get("name")).append(",").append(row.get("value")).append("\n");
        }
        return sb.toString();
    }

    private void saveReport(String csv) {
        System.out.println("Report saved: " + csv.length() + " chars");
    }
}
