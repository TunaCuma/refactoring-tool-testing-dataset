package org.example.long_method.medium;

import java.util.List;

public class StringStatistics {
    public String generateReport(List<String> inputs) {
        int count = inputs.size();
        int totalLength = 0;
        for (String s : inputs) {
            totalLength += s.length();
        }
        double average = count == 0 ? 0 : (double) totalLength / count;

        String longest = "";
        String shortest = count == 0 ? "" : inputs.get(0);
        for (String s : inputs) {
            if (s.length() > longest.length()) {
                longest = s;
            }
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("Count: ").append(count).append("\n");
        report.append("Total Length: ").append(totalLength).append("\n");
        report.append("Average Length: ")
              .append(String.format("%.2f", average)).append("\n");
        report.append("Longest: ").append(longest).append("\n");
        report.append("Shortest: ").append(shortest).append("\n");
        report.append("All Strings:\n");
        for (String s : inputs) {
            report.append(s).append("\n");
        }

        return report.toString();
    }
}
