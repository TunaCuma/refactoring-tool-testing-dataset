package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserManagerTest {
    @Test
    void testRegisterAndLogin() {
        UserManager um = new UserManager();
        assertTrue(um.handleUser("register","u","p").contains("Registered u"));
        assertTrue(um.handleUser("login","u","p").contains("Welcome u"));
    }

    @Test
    void testLoginFailures() {
        UserManager um = new UserManager();
        assertTrue(um.handleUser("login","x","y").contains("No such user."));
    }
}
