package org.example.strategy_pattern.hard;

public class DataParser {
    public Object parse(String type, String input) {
        if (type.equals("JSON")) {
            // pretend to parse JSON
            return new com.google.gson.JsonParser().parse(input);
        } else if (type.equals("XML")) {
            // pretend to parse XML
            return javax.xml.parsers.DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(new java.io.ByteArrayInputStream(input.getBytes()));
        } else if (type.equals("CSV")) {
            String[] rows = input.split(";");
            List<String[]> data = new java.util.ArrayList<>();
            for (String row : rows) data.add(row.split(","));
            return data;
        }
        return null;
    }
}
