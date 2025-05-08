package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NotificationManagerTest {
    @Test
    void testSendEmailAndSMS() {
        NotificationManager nm = new NotificationManager();
        nm.sendEmail("a@b.com", "hi");
        nm.sendSMS("12345", "hello");
        assertTrue(nm.getSent().stream().anyMatch(s -> s.startsWith("EMAIL:")));
    }
    @Test
    void testScheduleAndCancel() {
        NotificationManager nm = new NotificationManager();
        nm.scheduleNotification("n1", java.time.LocalDateTime.now());
        nm.cancelNotification("n1");
        assertFalse(nm.getSent().stream().anyMatch(s -> s.contains("n1")));
    }
}
