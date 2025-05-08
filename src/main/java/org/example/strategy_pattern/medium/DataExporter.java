package org.example.strategy_pattern.medium;

public class DataExporter {
    public String export(String format, Object data) {
        if ("CSV".equals(format)) {
            return "csv:" + data.toString();
        } else if ("XML".equals(format)) {
            return "<data>" + data + "</data>";
        } else if ("JSON".equals(format)) {
            return "{\"data\":\"" + data + "\"}";
        }
        throw new IllegalArgumentException("Format not supported: " + format);
    }
}
