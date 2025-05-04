package org.example.long_method.hard;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ClusterMigrationManager {
    public boolean migrateCluster(DatabaseCluster source, DatabaseCluster target) {
        try {
            source.connect();
            target.connect();

            List<String> tables = source.listTables();
            Map<String, Integer> rowCountMap = new HashMap<>();

            for (String table : tables) {
                source.beginTransaction();
                List<Map<String, Object>> rows = source.readTable(table);
                rowCountMap.put(table, rows.size());

                List<Map<String, Object>> transformed = transformRows(rows);

                target.beginTransaction();
                for (Map<String, Object> row : transformed) {
                    target.insertRow(table, row);
                }

                source.commitTransaction();
                target.commitTransaction();
                log("Migrated table: " + table + ", rows: " + rowCountMap.get(table));
            }

            // verify counts
            for (String table : tables) {
                int srcCount = source.getRowCount(table);
                int tgtCount = target.getRowCount(table);
                if (srcCount != tgtCount) {
                    throw new IllegalStateException(
                        "Row count mismatch for " + table
                    );
                }
            }

            source.disconnect();
            target.disconnect();
            return true;

        } catch (Exception e) {
            log("Migration failed: " + e.getMessage());
            try {
                source.rollback();
                target.rollback();
            } catch (Exception ex) {
                log("Rollback failed: " + ex.getMessage());
            }
            return false;
        }
    }

    private List<Map<String, Object>> transformRows(List<Map<String, Object>> rows) {
        // Complex normalization & cleanup
        for (Map<String, Object> row : rows) {
            for (Map.Entry<String, Object> e : row.entrySet()) {
                if (e.getValue() instanceof String) {
                    String v = ((String) e.getValue()).trim().toUpperCase();
                    e.setValue(v);
                }
            }
        }
        return rows;
    }

    private void log(String msg) {
        System.out.println("[ClusterMigrationManager] " + msg);
    }
}

// Stub classes for demonstration/testing
class DatabaseCluster {
    public void connect() {}
    public void disconnect() {}
    public List<String> listTables() { return List.of(); }
    public List<Map<String, Object>> readTable(String table) { return List.of(); }
    public void insertRow(String table, Map<String, Object> row) {}
    public void beginTransaction() {}
    public void commitTransaction() {}
    public void rollback() {}
    public int getRowCount(String table) { return 0; }
}
