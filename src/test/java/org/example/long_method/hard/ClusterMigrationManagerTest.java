package org.example.long_method.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClusterMigrationManagerTest {
    @Test
    public void testMigrateCluster_Empty() {
        ClusterMigrationManager mgr = new ClusterMigrationManager();
        DatabaseCluster src = new DatabaseCluster();
        DatabaseCluster tgt = new DatabaseCluster();
        // with no tables, should succeed
        assertTrue(mgr.migrateCluster(src, tgt));
    }
}
