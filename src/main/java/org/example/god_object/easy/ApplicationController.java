package org.example.god_object.easy;

public class ApplicationController {
    private boolean running = false;

    public void startApp() {
        running = true;
    }

    public void stopApp() {
        running = false;
    }

    public void restartApp() {
        stopApp();
        startApp();
    }

    public String getStatus() {
        return running ? "RUNNING" : "STOPPED";
    }

    public void shutdown() {
        running = false;
        writeLog("SHUTDOWN");
    }

    private java.util.List<String> logs = new java.util.ArrayList<>();
    private void writeLog(String msg) {
        logs.add(msg);
    }
    public java.util.List<String> getLogs() {
        return logs;
    }
}
