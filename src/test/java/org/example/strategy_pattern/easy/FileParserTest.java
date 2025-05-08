package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    @Test
    void testParseJson() {
        FileParser fp = new FileParser();
        assertTrue(fp.parse("{}", "JSON").contains("Parsed JSON"));
    }

    @Test
    void testParseUnknown() {
        FileParser fp = new FileParser();
        assertEquals("Unknown type", fp.parse("data", "YAML"));
    }
}
