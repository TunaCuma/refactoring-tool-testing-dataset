package org.example.long_method.easy;

public class XmlParser {
    /**
     * Parses a simple XML-like string into a map of tag->value.
     */
    public java.util.Map<String,String> parse(String xml) {
        java.util.Map<String,String> map = new java.util.HashMap<>();
        if (xml == null || xml.isEmpty()) return map;
        String[] parts = xml.split("<");
        for (String part : parts) {
            if (!part.contains(">")) continue;
            String tag = part.substring(0, part.indexOf(">"));
            String rest = part.substring(part.indexOf(">")+1);
            if (!rest.contains("</")) continue;
            String value = rest.substring(0, rest.indexOf("</"));
            map.put(tag, value);
        }
        return map;
    }
}
