package org.example.god_object.easy;

public class DatabaseFacade {
    private boolean connected = false;

    public void connect(String url) {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public java.util.List<java.util.Map<String, Object>> executeQuery(String sql) {
        return new java.util.ArrayList<>();
    }

    public void beginTransaction() {
        writeLog("BEGIN");
    }

    public void commitTransaction() {
        writeLog("COMMIT");
    }

    private java.util.List<String> logs = new java.util.ArrayList<>();
    private void writeLog(String msg) {
        logs.add(msg);
    }
    public java.util.List<String> getLogs() {
        return logs;
    }
}
