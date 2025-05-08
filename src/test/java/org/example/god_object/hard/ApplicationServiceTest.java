package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ApplicationServiceTest {
    @Test
    void testStartStop() throws Exception {
        ApplicationService svc = new ApplicationService("jdbc:h2:mem:test",5);
        svc.start(); assertTrue(svc.isActive()); svc.stop(); assertFalse(svc.isActive());
    }
    @Test
    void testHandleRequest() throws Exception {
        ApplicationService svc = new ApplicationService("jdbc:h2:mem:test",2);
        svc.start(); String resp = svc.handleRequest("u1","data");
        assertEquals("OK:data", resp);
    }
}
