package org.example.strategy_pattern.hard;

public class ReportExporter {
    public void export(String format, Object data) {
        if (format.equals("PDF")) {
            System.out.println("Generating PDF");
            // complex PDF logic
        } else if (format.equals("EXCEL")) {
            System.out.println("Generating Excel");
            // complex Excel logic
        } else if (format.equals("CSV")) {
            System.out.println("Generating CSV");
            // complex CSV logic
        } else if (format.equals("HTML")) {
            System.out.println("Generating HTML");
            // complex HTML logic
        } else {
            System.out.println("Unknown format");
        }
    }
}
