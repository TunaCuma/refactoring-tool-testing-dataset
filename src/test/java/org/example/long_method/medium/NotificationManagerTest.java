package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class NotificationManagerTest {
    @Test
    void testSendMixed() {
        Map<String,String> users = Map.of(
            "alice", "email",
            "bob", "sms",
            "eve", "push"
        );
        var res = new NotificationManager().sendBulkNotification(users, "Hi", "Content");
        assertEquals(3, res.size());
        assertTrue(res.stream().anyMatch(r -> r.startsWith("Email to alice")));
    }
}
