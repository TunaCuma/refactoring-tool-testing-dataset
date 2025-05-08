package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DataParserTest {
    @Test
    void testCsv() {
        DataParser dp = new DataParser();
        Object result = dp.parse("CSV", "A,B;C,D");
        assertTrue(result instanceof java.util.List);
    }
    @Test
    void testUnknown() {
        DataParser dp = new DataParser();
        assertNull(dp.parse("YAML", "a:1"));
    }
}
