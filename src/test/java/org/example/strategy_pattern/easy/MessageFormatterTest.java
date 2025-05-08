package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageFormatterTest {
    @Test
    void testFormatUppercase() {
        MessageFormatter mf = new MessageFormatter();
        assertEquals("HELLO WORLD", mf.format("hello world", "UPPERCASE"));
    }

    @Test
    void testFormatCamel() {
        MessageFormatter mf = new MessageFormatter();
        assertEquals("HelloWorld", mf.format("hello world", "CAMEL"));
    }
}
