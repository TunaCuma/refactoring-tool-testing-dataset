package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DocumentRendererTest {
    @Test
    void testHtmlRender() {
        DocumentRenderer dr = new DocumentRenderer();
        assertEquals("<p>Hello</p>", dr.render("HTML", "Hello"));
    }
    @Test
    void testRenderException() {
        DocumentRenderer dr = new DocumentRenderer();
        assertThrows(IllegalArgumentException.class, () -> dr.render("TXT", "Hi"));
    }
}
