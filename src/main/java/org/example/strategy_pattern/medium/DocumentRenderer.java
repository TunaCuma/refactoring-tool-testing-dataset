package org.example.strategy_pattern.medium;

public class DocumentRenderer {
    public String render(String format, String text) {
        if ("PDF".equals(format)) {
            return "[PDF] " + text;
        } else if ("HTML".equals(format)) {
            return "<p>" + text + "</p>";
        } else if ("DOCX".equals(format)) {
            return "<w:docx>" + text + "</w:docx>";
        }
        throw new IllegalArgumentException("Unsupported format: " + format);
    }
}
