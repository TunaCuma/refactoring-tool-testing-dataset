package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NotificationManagerTest {
    @Test
    void testNotifyUsersEmptyList() {
        NotificationManager nm = new NotificationManager();
        nm.notifyUsers(Collections.emptyList(), "Hello");
        assertTrue(true);
    }

    @Test
    void testNotifyUsersNullMessage() {
        NotificationManager nm = new NotificationManager();
        assertThrows(NullPointerException.class, () -> nm.notifyUsers(List.of("u1"), null));
    }
}
