package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserServiceTest {
    @Test
    void testRegisterAndAuthenticate() {
        UserService us = new UserService();
        us.registerUser("john", "pass");
        assertTrue(us.authenticate("john", "pass"));
    }
    @Test
    void testDeactivate() {
        UserService us = new UserService();
        us.registerUser("jane", "123");
        us.authenticate("jane", "123");
        us.deactivateUser("jane");
        assertFalse(us.isActive("jane"));
    }
}
