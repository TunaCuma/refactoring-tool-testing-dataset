package org.example.strategy_pattern.easy;

public class MessageFormatter {
    /**
     * Formats message based on style.
     */
    public String format(String message, String style) {
        if (style.equals("UPPERCASE")) {
            return message.toUpperCase();
        } else if (style.equals("LOWERCASE")) {
            return message.toLowerCase();
        } else if (style.equals("CAMEL")) {
            String[] parts = message.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String p : parts) {
                sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1));
            }
            return sb.toString();
        }
        return message;
    }
}
