package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
import java.util.*;
class EmailTemplateEngineTest {
    @Test
    void testRenderBasic(tmpdir: Path) throws Exception {
        Path t = tmpdir.resolve("t.html");
        Files.writeString(t, "Hello {{name}}! {{#if vip}}VIP{{/if}}");
        String out = new EmailTemplateEngine().render(t.toString(), Map.of("name","Bob","vip",true));
        assertTrue(out.contains("Hello Bob!"));
        assertTrue(out.contains("VIP"));
    }
    @Test
    void testRenderMissing() {
        assertEquals("Template load error", new EmailTemplateEngine().render("nope", Map.of()));
    }
}
