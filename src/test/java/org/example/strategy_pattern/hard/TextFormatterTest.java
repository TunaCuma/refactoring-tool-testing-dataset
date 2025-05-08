package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TextFormatterTest {
    @Test
    void testCamel() {
        TextFormatter tf = new TextFormatter();
        assertEquals("HelloWorld", tf.format("CAMEL", "hello world"));
    }
    @Test
    void testLower() {
        TextFormatter tf = new TextFormatter();
        assertEquals("hi", tf.format("LOWER", "HI"));
    }
}
