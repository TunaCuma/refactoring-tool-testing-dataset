package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SessionManagerTest {
    @Test
    void testCreateAndValidate() {
        SessionManager sm = new SessionManager();
        String id = sm.createSession("user1");
        assertTrue(sm.validateSession(id));
    }
    @Test
    void testInvalidate() {
        SessionManager sm = new SessionManager();
        String id = sm.createSession("user2");
        sm.invalidateSession(id);
        assertFalse(sm.validateSession(id));
    }
}
