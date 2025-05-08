package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class UIAndDataControllerTest {
    @Test
    void testInitShutdown() throws Exception {
        UIAndDataController ctrl = new UIAndDataController();
        ctrl.initUI(); assertTrue(ctrl.visible);
        assertTrue(ctrl.shutdown());
    }
    @Test
    void testLoadDataEmpty() throws Exception {
        UIAndDataController ctrl = new UIAndDataController();
        // without DB table, loadData should not throw
        ctrl.loadData();
        assertTrue(true);
    }
}
