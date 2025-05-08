package org.example.strategy_pattern.hard;

public class TextFormatter {
    public String format(String style, String text) {
        if (style.equals("UPPER")) {
            return text.toUpperCase();
        } else if (style.equals("LOWER")) {
            return text.toLowerCase();
        } else if (style.equals("CAMEL")) {
            // camel case logic
            String[] parts = text.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String p : parts) sb.append(p.substring(0,1).toUpperCase()).append(p.substring(1));
            return sb.toString();
        }
        return text;
    }
}
