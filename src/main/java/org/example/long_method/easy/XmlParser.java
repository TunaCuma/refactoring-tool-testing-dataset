package org.example.long_method.easy;

public class XmlParser {
    /**
     * Parses a simple XML-like string into a map of tag->value.
     */
    public java.util.Map<String,String> parse(String xml) {
        java.util.Map<String,String> map = new java.util.HashMap<>();
        if (xml == null || xml.isEmpty()) return map;
        
        // Find each <tag>content</tag> pattern
        int i = 0;
        while (i < xml.length()) {
            int openStart = xml.indexOf('<', i);
            if (openStart == -1) break;
            
            int openEnd = xml.indexOf('>', openStart);
            if (openEnd == -1) break;
            
            // Skip closing tags
            if (openStart + 1 < xml.length() && xml.charAt(openStart + 1) == '/') {
                i = openEnd + 1;
                continue;
            }
            
            String tag = xml.substring(openStart + 1, openEnd);
            
            int closeTagStart = xml.indexOf("</" + tag + ">", openEnd);
            if (closeTagStart == -1) break;
            
            String value = xml.substring(openEnd + 1, closeTagStart);
            map.put(tag, value);
            
            i = closeTagStart + tag.length() + 3;
        }
        
        return map;
    }
}
