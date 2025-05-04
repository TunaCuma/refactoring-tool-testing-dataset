package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class CacheManagerTest {
    @Test
    void testManage() {
        Map<String,String> init = Map.of("a","1","b","2","c","3");
        String res = new CacheManager().manage(init, 2, 1000);
        assertTrue(res.startsWith("Cache size="));
    }
}
