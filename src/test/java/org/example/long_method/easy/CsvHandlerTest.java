package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class CsvHandlerTest {
    @Test
    void testReadCsv() {
        CsvHandler ch = new CsvHandler();
        String csv = "a,b,c\n1,2,3";
        List<List<String>> out = ch.readCsv(csv);
        assertEquals(2, out.size());
        assertEquals(Arrays.asList("a","b","c"), out.get(0));
        assertEquals(Arrays.asList("1","2","3"), out.get(1));
    }

    @Test
    void testReadCsvEmpty() {
        CsvHandler ch = new CsvHandler();
        assertTrue(ch.readCsv("").isEmpty());
    }
}
