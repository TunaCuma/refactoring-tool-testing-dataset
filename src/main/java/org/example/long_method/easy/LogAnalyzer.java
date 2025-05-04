package org.example.long_method.easy;

public class LogAnalyzer {
    /**
     * Analyzes log lines, counts error types, and returns a summary.
     */
    public String analyze(java.util.List<String> logs) {
        if (logs == null) return "No logs provided.";
        int info=0, warn=0, error=0;
        for (String line : logs) {
            if (line.contains("INFO")) info++;
            else if (line.contains("WARN")) warn++;
            else if (line.contains("ERROR")) error++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("INFO: ").append(info).append("\n");
        sb.append("WARN: ").append(warn).append("\n");
        sb.append("ERROR: ").append(error);
        return sb.toString();
    }
}
