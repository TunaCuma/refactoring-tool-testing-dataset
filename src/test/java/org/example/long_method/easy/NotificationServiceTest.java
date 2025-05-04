package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class NotificationServiceTest {
    @Test
    void testNotifyUsers() {
        NotificationService ns = new NotificationService();
        Map<String,Boolean> prefs = new HashMap<>();
        prefs.put("a", true); prefs.put("b", false);
        List<String> out = ns.notifyUsers(prefs, "Hi");
        assertEquals(1, out.size());
        assertTrue(out.get(0).contains("Sent to a"));
    }

    @Test
    void testNotifyNone() {
        NotificationService ns = new NotificationService();
        assertTrue(ns.notifyUsers(new HashMap<>(), "x").isEmpty());
    }
}
