package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AddressFormatterTest {
    @Test
    void testFormatValid() {
        CustomerA c = new CustomerA("123 Main St", "Springfield", "12345", "USA");
        assertEquals("123 Main St, Springfield 12345, USA", new AddressFormatter().format(c));
    }
    @Test
    void testFormatNull() {
        assertEquals("", new AddressFormatter().format(null));
    }
}
