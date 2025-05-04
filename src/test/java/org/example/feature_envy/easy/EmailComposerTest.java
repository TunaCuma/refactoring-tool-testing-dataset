package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EmailComposerTest {
    @Test
    void testComposeGreeting() {
        User u = new User("Jane", "Doe");
        assertEquals("Hello, Jane Doe", new EmailComposer().composeGreeting(u));
    }
    @Test
    void testComposeGreetingNull() {
        assertEquals("Hello, Guest", new EmailComposer().composeGreeting(null));
    }
}
