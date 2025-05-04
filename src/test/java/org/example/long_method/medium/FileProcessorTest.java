package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.*;
class FileProcessorTest {
    @Test
    void testProcessFile(tmpdir: Path) throws Exception {
        Path file = tmpdir.resolve("test.txt");
        Files.writeString(file, "#comment\na\nb\na\n");
        String out = new FileProcessor().processFile(file.toString());
        assertTrue(out.contains("a->2"));
        assertTrue(Files.exists(tmpdir.resolve("test.txt.bak")));
    }
    @Test
    void testMissingFile() {
        assertEquals("Error reading file.", new FileProcessor().processFile("nope.txt"));
    }
}
