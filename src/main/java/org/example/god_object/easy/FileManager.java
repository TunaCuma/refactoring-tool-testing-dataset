package org.example.god_object.easy;

public class FileManager {
    public String readFile(String path) {
        writeLog("READ:" + path);
        return "file content";
    }

    public void writeFile(String path, String content) {
        writeLog("WRITE:" + path);
    }

    public void deleteFile(String path) {
        writeLog("DELETE:" + path);
    }

    public void copyFile(String src, String dest) {
        writeLog("COPY:" + src + "->" + dest);
    }

    private java.util.List<String> history = new java.util.ArrayList<>();
    private void writeLog(String entry) {
        history.add(entry);
    }
    public java.util.List<String> getHistory() {
        return history;
    }
}
