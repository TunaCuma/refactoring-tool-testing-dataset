package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class CentralManagerTest {
    @Test
    void testInitialize() throws Exception {
        CentralManager mgr = new CentralManager();
        mgr.initialize();
        assertTrue(mgr.isInitialized());
    }
    @Test
    void testFetchDataEmpty() throws Exception {
        CentralManager mgr = new CentralManager();
        mgr.initialize();
        assertNotNull(mgr.fetchData());
    }
}
