package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CompressionServiceTest {
    @Test
    void testZipCompression() {
        CompressionService cs = new CompressionService();
        byte[] dummy = {1,2,3};
        assertEquals(3, cs.compress("ZIP", dummy).length);
    }
    @Test
    void testUnsupportedAlgorithm() {
        CompressionService cs = new CompressionService();
        assertThrows(UnsupportedOperationException.class, () -> cs.compress("GZIP", new byte[0]));
    }
}
