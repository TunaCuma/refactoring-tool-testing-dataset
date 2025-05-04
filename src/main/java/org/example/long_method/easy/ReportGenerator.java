package org.example.long_method.easy;

public class ReportGenerator {
    /**
     * Generates a report by validating input, summarizing counts, and formatting output.
     */
    public String generateReport(String[] items) {
        // 1. Validate input
        if (items == null || items.length == 0) {
            return "No items to report.";
        }
        // 2. Count occurrences
        java.util.Map<String, Integer> counts = new java.util.HashMap<>();
        for (String item : items) {
            if (item == null) continue;
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        // 3. Build report header
        StringBuilder sb = new StringBuilder();
        sb.append("Report:\n");
        sb.append("--------\n");
        // 4. Append counts
        for (java.util.Map.Entry<String, Integer> entry : counts.entrySet()) {
            sb.append(entry.getKey())
              .append(": ")
              .append(entry.getValue())
              .append("\n");
        }
        // 5. Add footer with total
        int total = 0;
        for (int c : counts.values()) {
            total += c;
        }
        sb.append("--------\n");
        sb.append("Total items: ").append(total);
        return sb.toString();
    }
}
