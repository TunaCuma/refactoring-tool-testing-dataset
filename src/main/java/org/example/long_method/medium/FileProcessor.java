package org.example.long_method.medium;

public class FileProcessor {
    /**
     * Opens file, parses lines, applies rules, summarizes, and archives.
     */
    public String processFile(String path) {
        // 1. Read
        java.util.List<String> lines;
        try {
            lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
        } catch (Exception e) {
            return "Error reading file.";
        }
        if (lines.isEmpty()) {
            return "Empty file.";
        }
        // 2. Parse and filter
        java.util.List<String> data = new java.util.ArrayList<>();
        for (String line : lines) {
            if (line.startsWith("#")) continue;
            data.add(line.trim());
        }
        // 3. Transform
        java.util.Map<String,Integer> freq = new java.util.HashMap<>();
        for (String d : data) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }
        // 4. Summarize
        StringBuilder sb = new StringBuilder();
        sb.append("Summary:\n");
        for (var e : freq.entrySet()) {
            sb.append(e.getKey()).append("->").append(e.getValue()).append("\n");
        }
        // 5. Archive
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(path + ".bak"), lines);
        } catch (Exception ignored) {}
        return sb.toString();
    }
}
