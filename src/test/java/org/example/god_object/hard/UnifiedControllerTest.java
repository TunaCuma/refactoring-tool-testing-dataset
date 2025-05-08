package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class UnifiedControllerTest {
    @Test
    void testRecord() {
        UnifiedController uc = new UnifiedController("localhost",80);
        uc.record("ping","pong"); assertEquals("pong", uc.responses.get("ping"));
    }
    @Test
    void testClose() throws Exception { UnifiedController uc = new UnifiedController("localhost",80);
        uc.connected=true; uc.close(); assertFalse(uc.connected);
    }
}
