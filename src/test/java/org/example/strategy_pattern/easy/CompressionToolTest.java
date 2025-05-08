package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompressionToolTest {
    @Test
    void testCompressZip() {
        CompressionTool ct = new CompressionTool();
        assertArrayEquals(new byte[]{1}, ct.compress(new byte[]{0}, "ZIP"));
    }

    @Test
    void testCompressDefault() {
        CompressionTool ct = new CompressionTool();
        byte[] data = {0};
        assertArrayEquals(data, ct.compress(data, "UNKNOWN"));
    }
}
