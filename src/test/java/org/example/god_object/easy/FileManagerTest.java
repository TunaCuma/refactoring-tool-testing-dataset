package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FileManagerTest {
    @Test
    void testReadAndWriteHistory() {
        FileManager fm = new FileManager();
        fm.readFile("/tmp/a.txt");
        fm.writeFile("/tmp/a.txt", "hi");
        assertEquals(2, fm.getHistory().size());
    }
    @Test
    void testCopyAndDelete() {
        FileManager fm = new FileManager();
        fm.copyFile("/a", "/b");
        fm.deleteFile("/b");
        assertTrue(fm.getHistory().stream().anyMatch(h -> h.startsWith("COPY:")));
    }
}
