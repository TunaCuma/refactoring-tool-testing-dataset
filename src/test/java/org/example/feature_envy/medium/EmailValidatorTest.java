package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EmailValidatorTest {
    @Test
    void testValid() {
        Email e = new Email("user", "example.com");
        assertTrue(new EmailValidator().isValid(e));
    }
    @Test
    void testInvalidLocal() {
        Email e = new Email("", "example.com");
        assertFalse(new EmailValidator().isValid(e));
    }
    @Test
    void testInvalidDomain() {
        Email e = new Email("user", "examplecom");
        assertFalse(new EmailValidator().isValid(e));
    }
    @Test
    void testValidNull() {
        assertFalse(new EmailValidator().isValid(null));
    }
}
