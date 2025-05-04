package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NotificationBuilderTest {
    @Test
    void testBuild() {
        Notification n = new Notification("a@b.com", "Hi", "Welcome!");
        String result = new NotificationBuilder().build(n);
        assertTrue(result.contains("To: a@b.com"));
        assertTrue(result.contains("Subject: Hi"));
        assertTrue(result.contains("Body: Welcome!"));
    }
    @Test
    void testBuildNull() {
        assertEquals("", new NotificationBuilder().build(null));
    }
}
