package org.example.long_method.easy;

public class CsvHandler {
    /**
     * Reads CSV text, splits into rows and columns, returns as 2D list.
     */
    public java.util.List<java.util.List<String>> readCsv(String csvText) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        if (csvText == null || csvText.isEmpty()) return result;
        String[] rows = csvText.split("\n");
        for (String row : rows) {
            java.util.List<String> cols = new java.util.ArrayList<>();
            for (String cell : row.split(",")) {
                cols.add(cell.trim());
            }
            result.add(cols);
        }
        return result;
    }
}
