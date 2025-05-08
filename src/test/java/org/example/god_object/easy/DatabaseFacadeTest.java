package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DatabaseFacadeTest {
    @Test
    void testConnectDisconnect() {
        DatabaseFacade db = new DatabaseFacade();
        db.connect("url");
        db.disconnect();
        assertFalse(db.getLogs().isEmpty() || db.getLogs().contains("COMMIT"));
    }
    @Test
    void testTransactionLogs() {
        DatabaseFacade db = new DatabaseFacade();
        db.beginTransaction();
        db.commitTransaction();
        assertTrue(db.getLogs().contains("BEGIN"));
        assertTrue(db.getLogs().contains("COMMIT"));
    }
}
