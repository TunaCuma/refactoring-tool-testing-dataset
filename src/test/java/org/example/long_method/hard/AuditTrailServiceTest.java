package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class AuditTrailServiceTest {
    @Test
    void testAudit() {
        var act = Map.of("user","u1","time",123L,"event","E");
        var users = Map.of("u1","Alice");
        int count = new AuditTrailService().audit(List.of(act), users);
        assertEquals(1, count);
    }
}
