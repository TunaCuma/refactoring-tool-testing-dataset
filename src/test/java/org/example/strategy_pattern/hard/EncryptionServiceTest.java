package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EncryptionServiceTest {
    @Test
    void testAes() {
        EncryptionService es = new EncryptionService();
        assertEquals("AES(secret)", es.encrypt("AES", "secret"));
    }
    @Test
    void testNone() {
        EncryptionService es = new EncryptionService();
        assertEquals("data", es.encrypt("NONE", "data"));
    }
}
