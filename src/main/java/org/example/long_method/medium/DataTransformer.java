package org.example.long_method.medium;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DataTransformer {
    public Map<String, Integer> transform(List<String> rawData) {
        Map<String, Integer> result = new HashMap<>();

        for (String entry : rawData) {
            if (entry == null || entry.isEmpty()) {
                continue;
            }
            String[] parts = entry.split(":");
            if (parts.length != 2) {
                continue;
            }
            String key = parts[0].trim();
            try {
                int value = Integer.parseInt(parts[1].trim());
                result.put(key, result.getOrDefault(key, 0) + value);
            } catch (NumberFormatException e) {
                // skip invalid numbers
            }
        }

        // adjust any negative totals back to zero
        for (Map.Entry<String, Integer> e : result.entrySet()) {
            if (e.getValue() < 0) {
                result.put(e.getKey(), 0);
            }
        }

        return result;
    }
}
