package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NotificationServiceTest {
    @Test
    void testEmail() {
        NotificationService svc = new NotificationService();
        assertDoesNotThrow(() -> svc.notifyUser("EMAIL", "Hello"));
    }
    @Test
    void testSlack() {
        NotificationService svc = new NotificationService();
        assertDoesNotThrow(() -> svc.notifyUser("SLACK", "Ping"));
    }
}
