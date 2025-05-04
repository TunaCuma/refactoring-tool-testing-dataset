package org.example.long_method.hard;

public class MigrationTool {
    /**
     * Connects to legacy DB, reads entities, transforms fields, writes to new DB,
     * handles batching, transactions, and rollback on failures.
     */
    public int migrate(java.sql.Connection legacy, java.sql.Connection target, int batchSize) {
        int migrated = 0;
        try {
            legacy.setAutoCommit(false);
            target.setAutoCommit(false);
            var stmt = legacy.createStatement();
            var rs = stmt.executeQuery("SELECT id,name,ts FROM records");
            java.util.List<java.util.Map<String,Object>> batch = new java.util.ArrayList<>();
            while (rs.next()) {
                java.util.Map<String,Object> rec = new java.util.HashMap<>();
                rec.put("id", rs.getInt("id"));
                rec.put("fullName", rs.getString("name").toUpperCase());
                rec.put("createdAt", rs.getTimestamp("ts"));
                batch.add(rec);
                if (batch.size() >= batchSize) {
                    migrated += writeBatch(target, batch);
                    batch.clear();
                }
            }
            if (!batch.isEmpty()) {
                migrated += writeBatch(target, batch);
            }
            target.commit();
            legacy.commit();
        } catch (Exception e) {
            try { target.rollback(); legacy.rollback(); } catch (Exception ex) {}
        }
        return migrated;
    }
    private int writeBatch(java.sql.Connection conn, java.util.List<java.util.Map<String,Object>> batch) throws Exception {
        var pstmt = conn.prepareStatement("INSERT INTO new_records(id,name,created) VALUES (?,?,?)");
        int count = 0;
        for (var rec : batch) {
            pstmt.setInt(1, (Integer)rec.get("id"));
            pstmt.setString(2, (String)rec.get("fullName"));
            pstmt.setTimestamp(3, (java.sql.Timestamp)rec.get("createdAt"));
            pstmt.addBatch();
        }
        var res = pstmt.executeBatch();
        for (int i : res) count += (i >= 0 ? i : 1);
        return count;
    }
}
