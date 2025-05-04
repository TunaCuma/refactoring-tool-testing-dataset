package org.example.long_method.hard;

public class AnalyticsService {
    /**
     * Loads data, applies multiple aggregation rules, joins with reference data,
     * computes metrics, generates report, and handles errors/logging.
     */
    public String runAnalytics(String dataPath, java.util.Map<Integer,String> refData) {
        // 1. Load raw lines
        java.util.List<String> lines;
        try {
            lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(dataPath));
        } catch (Exception e) {
            return "Failed to load data: " + e.getMessage();
        }
        // 2. Parse and filter
        java.util.List<java.util.Map<String,Object>> records = new java.util.ArrayList<>();
        for (String line : lines) {
            try {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                double value = Double.parseDouble(parts[1]);
                if (value <= 0) continue;
                java.util.Map<String,Object> rec = new java.util.HashMap<>();
                rec.put("id", id);
                rec.put("value", value);
                rec.put("timestamp", Long.parseLong(parts[2]));
                records.add(rec);
            } catch (Exception ignore) {
                // skip invalid
            }
        }
        if (records.isEmpty()) return "No valid records.";
        // 3. Join with refData
        for (var rec : records) {
            int id = (Integer) rec.get("id");
            rec.put("name", refData.getOrDefault(id, "UNKNOWN"));
        }
        // 4. Aggregate by name
        java.util.Map<String,Double> sums = new java.util.HashMap<>();
        for (var rec : records) {
            String name = (String) rec.get("name");
            sums.put(name, sums.getOrDefault(name, 0.0) + (Double)rec.get("value"));
        }
        // 5. Compute stats
        double total = sums.values().stream().mapToDouble(Double::doubleValue).sum();
        double max = sums.values().stream().mapToDouble(Double::doubleValue).max().orElse(0);
        // 6. Build report
        StringBuilder sb = new StringBuilder();
        sb.append("Analytics Report\n");
        sb.append("Total Value: ").append(total).append("\n");
        sb.append("Max Value: ").append(max).append("\n");
        sb.append("Breakdown:\n");
        for (var e : sums.entrySet()) {
            sb.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        }
        // 7. Log success
        System.out.println("Analytics run completed with " + records.size() + " records.");
        return sb.toString();
    }
}
