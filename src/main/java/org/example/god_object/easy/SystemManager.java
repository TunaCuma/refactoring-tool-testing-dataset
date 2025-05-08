package org.example.god_object.easy;

public class SystemManager {
    private java.util.Map<String, String> config = new java.util.HashMap<>();
    private java.util.List<String> logs = new java.util.ArrayList<>();

    public void loadConfig(String filename) {
        config.put("file", filename);
        config.put("date", java.time.LocalDate.now().toString());
    }

    public void writeLog(String message) {
        logs.add(java.time.LocalDateTime.now() + ": " + message);
    }

    public String getConfigValue(String key) {
        writeLog("Retrieving config for key: " + key);
        return config.getOrDefault(key, "");
    }

    public String processRequest(String request) {
        writeLog("Processing request: " + request);
        if (request == null || request.isEmpty()) {
            return "Invalid request.";
        }
        return "Processed: " + request.toUpperCase();
    }

    public void saveData(String filename, String data) {
        writeLog("Saving data to " + filename);
        // Simulate saving data
    }

    public String getLogSummary() {
        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }
}
