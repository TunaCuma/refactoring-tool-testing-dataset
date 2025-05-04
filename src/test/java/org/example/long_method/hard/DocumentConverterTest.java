package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
class DocumentConverterTest {
    @Test
    void testConvert(tmpdir: Path) throws Exception {
        Path doc = tmpdir.resolve("d.docx");
        Files.writeString(doc, "<h1>Title</h1><p>Text</p>");
        Path md = tmpdir.resolve("d.md");
        String out = new DocumentConverter().convert(doc.toString(), md.toString());
        assertEquals(md.toString(), out);
        assertTrue(Files.readString(md).contains("#1 Title"));
    }
}
