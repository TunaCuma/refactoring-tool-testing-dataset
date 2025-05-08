package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SystemManagerTest {
    @Test
    void testLoadAndGetConfig() {
        SystemManager sm = new SystemManager();
        sm.loadConfig("config.yml");
        assertEquals("config.yml", sm.getConfigValue("file"));
    }
    @Test
    void testWriteAndSummary() {
        SystemManager sm = new SystemManager();
        sm.writeLog("Test log");
        assertTrue(sm.getLogSummary().contains("Test log"));
    }
    @Test
    void testProcessRequest() {
        SystemManager sm = new SystemManager();
        assertEquals("Processed: HELLO", sm.processRequest("hello"));
        assertEquals("Invalid request.", sm.processRequest(""));
    }
}
