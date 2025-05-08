package org.example.strategy_pattern.medium;

public class ReportFormatter {
    public String formatReport(String type, String content) {
        if ("HTML".equals(type)) {
            return "<html><body>" + content + "</body></html>";
        } else if ("XML".equals(type)) {
            return "<report>" + content + "</report>";
        } else if ("JSON".equals(type)) {
            return "{ \"report\": \"" + content + "\" }";
        }
        return content;
    }
}
