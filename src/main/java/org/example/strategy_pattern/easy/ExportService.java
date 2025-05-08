package org.example.strategy_pattern.easy;

public class ExportService {
    /**
     * Exports data in various formats.
     */
    public String exportData(String format, String data) {
        String result;
        switch (format) {
            case "PDF":
                result = "Exporting to PDF: " + data;
                break;
            case "CSV":
                result = "Exporting to CSV: " + data;
                break;
            case "XML":
                result = "Exporting to XML: " + data;
                break;
            case "JSON":
                result = "Exporting to JSON: " + data;
                break;
            default:
                result = "Format not supported: " + format;
                break;
        }
        return result;
    }
}
