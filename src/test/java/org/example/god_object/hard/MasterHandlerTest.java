package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class MasterHandlerTest {
    @Test
    void testAddAndExecute() {
        MasterHandler m = new MasterHandler(); m.maxTasks=2; m.addTask("a"); m.addTask("b"); m.executeAll();
        assertTrue(m.isRunning()); assertTrue(m.status.get("a"));
    }
    @Test
    void testOverload() {
        MasterHandler m = new MasterHandler(); m.maxTasks=1; m.addTask("a"); m.addTask("b");
        assertEquals(1, m.tasks.size());
    }
}
