package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationSenderTest {
    @Test
    void testSendSms() {
        NotificationSender ns = new NotificationSender();
        assertTrue(ns.send("SMS", "Hello").contains("SMS sent"));
    }

    @Test
    void testSendUnsupported() {
        NotificationSender ns = new NotificationSender();
        assertTrue(ns.send("FAX", "Hello").contains("not supported"));
    }
}
