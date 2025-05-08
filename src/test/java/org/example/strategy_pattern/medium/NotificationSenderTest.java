package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NotificationSenderTest {
    @Test
    void testEmailChannel() {
        NotificationSender sender = new NotificationSender();
        assertTrue(sender.send("EMAIL", "Hello").contains("Email sent"));
    }
    @Test
    void testInvalidChannel() {
        NotificationSender sender = new NotificationSender();
        assertThrows(RuntimeException.class, () -> sender.send("FAX", "Hi"));
    }
}
