package org.example.long_method.hard;

public class CacheManager {
    /**
     * Initializes cache, loads entries, evicts old items, writes-through, and metrics.
     */
    public String manage(java.util.Map<String,String> initial, int maxSize, long ttl) {
        java.util.Map<String,java.util.Map.Entry<String,Long>> cache = new java.util.LinkedHashMap<>();
        long now = System.currentTimeMillis();
        // load
        for (var e : initial.entrySet()) {
            cache.put(e.getKey(), new java.util.AbstractMap.SimpleEntry<>(e.getValue(), now));
        }
        // simulate usage
        for (var k : cache.keySet()) {
            // check ttl
            if (now - cache.get(k).getValue() > ttl) cache.remove(k);
        }
        // evict oldest
        while (cache.size() > maxSize) {
            String first = cache.keySet().iterator().next();
            cache.remove(first);
        }
        // write-through stub
        for (var e : cache.entrySet()) {
            writeThrough(e.getKey(), e.getValue().getKey());
        }
        return "Cache size=" + cache.size();
    }
    private void writeThrough(String k, String v) {}
}
