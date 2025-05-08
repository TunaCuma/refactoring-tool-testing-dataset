package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ApplicationControllerTest {
    @Test
    void testStartStop() {
        ApplicationController ac = new ApplicationController();
        ac.startApp();
        assertEquals("RUNNING", ac.getStatus());
        ac.stopApp();
        assertEquals("STOPPED", ac.getStatus());
    }
    @Test
    void testRestartAndShutdown() {
        ApplicationController ac = new ApplicationController();
        ac.startApp();
        ac.restartApp();
        assertEquals("RUNNING", ac.getStatus());
        ac.shutdown();
        assertTrue(ac.getLogs().contains("SHUTDOWN"));
    }
}
