package org.example.strategy_pattern.easy;

public class FileParser {
    /**
     * Parses file content based on type.
     */
    public String parse(String content, String type) {
        if (type.equals("JSON")) {
            return "Parsed JSON: " + content;
        } else if (type.equals("XML")) {
            return "Parsed XML: " + content;
        } else if (type.equals("TEXT")) {
            return "Parsed Text: " + content;
        }
        return "Unknown type";
    }
}
