package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class DataExporterTest {
    @Test
    void testExportCsv() {
        Map<String,Object> r1 = new HashMap<>();
        r1.put("active", true);
        r1.put("timestamp", 0L);
        r1.put("value", 10);
        String csv = new DataExporter().exportData(List.of(r1), "CSV");
        assertTrue(csv.contains("active"));
        assertTrue(csv.contains("timestamp"));
        assertTrue(csv.contains("value"));
        assertTrue(csv.contains("date"));
        assertTrue(csv.contains("true"));
        assertTrue(csv.contains("0"));
        assertTrue(csv.contains("10"));
        assertTrue(csv.contains("1970-01-01"));
    }
    @Test
    void testExportJson() {
        Map<String,Object> r1 = new HashMap<>();
        r1.put("active", true);
        r1.put("timestamp", 1000L);
        String json = new DataExporter().exportData(List.of(r1), "JSON");
        assertTrue(json.startsWith("["));
        assertTrue(json.contains("\"active\":true"));
    }
    @Test
    void testEmptyRecords() {
        assertEquals("No data to export.", new DataExporter().exportData(Collections.emptyList(), "CSV"));
    }
}
