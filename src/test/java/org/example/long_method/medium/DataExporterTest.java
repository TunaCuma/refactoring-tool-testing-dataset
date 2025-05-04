package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class DataExporterTest {
    @Test
    void testExportCsv() {
        Map<String,Object> r1 = Map.of("active", true, "timestamp", 0L, "value", 10);
        String csv = new DataExporter().exportData(List.of(r1), "CSV");
        assertTrue(csv.startsWith("active,timestamp,value,date"));
        assertTrue(csv.contains("true,0,10,1970-01-01"));
    }
    @Test
    void testExportJson() {
        Map<String,Object> r1 = Map.of("active", true, "timestamp", 1000L);
        String json = new DataExporter().exportData(List.of(r1), "JSON");
        assertTrue(json.startsWith("["));
        assertTrue(json.contains("\"active\":true"));
    }
    @Test
    void testEmptyRecords() {
        assertEquals("No data to export.", new DataExporter().exportData(Collections.emptyList(), "CSV"));
    }
}
