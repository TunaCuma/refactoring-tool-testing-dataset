package org.example.long_method.medium;

public class DataExporter {
    /**
     * Reads records, filters, transforms, and exports to CSV or JSON.
     */
    public String exportData(java.util.List<java.util.Map<String,Object>> records, String format) {
        // 1. Validate inputs
        if (records == null || records.isEmpty()) {
            return "No data to export.";
        }
        if (!"CSV".equalsIgnoreCase(format) && !"JSON".equalsIgnoreCase(format)) {
            throw new IllegalArgumentException("Unsupported format: " + format);
        }
        // 2. Filter out inactive
        java.util.List<java.util.Map<String,Object>> filtered = new java.util.ArrayList<>();
        for (var rec : records) {
            Object active = rec.get("active");
            if (Boolean.TRUE.equals(active)) {
                filtered.add(rec);
            }
        }
        // 3. Transform values
        for (var rec : filtered) {
            if (rec.containsKey("timestamp")) {
                long ts = (Long)rec.get("timestamp");
                rec.put("date", new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(ts)));
            }
        }
        // 4. Build output
        StringBuilder sb = new StringBuilder();
        if ("CSV".equalsIgnoreCase(format)) {
            java.util.Set<String> keys = new java.util.LinkedHashSet<>();
            for (var rec : filtered) {
                keys.addAll(rec.keySet());
            }
            var sortedKeys = new java.util.ArrayList<>(keys);
            java.util.Collections.sort(sortedKeys);
            
            // header
            sb.append(String.join(",", sortedKeys)).append("\n");
            // rows
            for (var rec : filtered) {
                java.util.List<String> row = new java.util.ArrayList<>();
                for (var k : sortedKeys) row.add(String.valueOf(rec.get(k)));
                sb.append(String.join(",", row)).append("\n");
            }
        } else {
            // JSON array
            sb.append("[");
            for (int i = 0; i < filtered.size(); i++) {
                sb.append(new com.google.gson.Gson().toJson(filtered.get(i)));
                if (i < filtered.size() - 1) sb.append(",");
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
