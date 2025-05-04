package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
class MigrationToolTest {
    @Test
    void testMigrateEmpty() throws Exception {
        Connection legacy = DriverManager.getConnection("jdbc:h2:mem:old");
        Connection target = DriverManager.getConnection("jdbc:h2:mem:new");
        legacy.createStatement().execute("CREATE TABLE records(id INT,name VARCHAR,ts TIMESTAMP)");
        target.createStatement().execute("CREATE TABLE new_records(id INT,name VARCHAR,created TIMESTAMP)");
        int count = new MigrationTool().migrate(legacy, target, 10);
        assertEquals(0, count);
    }
}
