package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class XmlParserTest {
    @Test
    void testParseSimple() {
        XmlParser xp = new XmlParser();
        Map<String,String> m = xp.parse("<a>Hello</a><b>World</b>");
        assertEquals("Hello", m.get("a"));
        assertEquals("World", m.get("b"));
    }

    @Test
    void testParseEmpty() {
        XmlParser xp = new XmlParser();
        assertTrue(xp.parse("").isEmpty());
    }
}
