package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserProfileManagerTest {
    @Test
    void testUpdateProfileValid() {
        UserProfileManager upm = new UserProfileManager();
        upm.updateProfile("user1", "data");
        assertEquals("data", upm.getProfile("user1"));
    }

    @Test
    void testUpdateProfileInvalid() {
        UserProfileManager upm = new UserProfileManager();
        assertThrows(IllegalArgumentException.class, () -> upm.updateProfile(null, null));
    }
}
