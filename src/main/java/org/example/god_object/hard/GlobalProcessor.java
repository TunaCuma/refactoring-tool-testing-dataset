package org.example.god_object.hard;

public class GlobalProcessor {
    private java.util.List<Integer> numbers = new java.util.ArrayList<>();
    private java.util.Map<Integer,String> map = new java.util.HashMap<>();
    private int sum;
    private double average;
    private String summary;
    private java.io.File outFile;
    private java.io.BufferedWriter bw;
    private boolean processed;
    private java.time.LocalDateTime timestamp;
    private java.net.Socket sock;
    private java.util.Properties props = new java.util.Properties();

    public void ingest(int n) { numbers.add(n); }
    public void computeStats() {
        sum = numbers.stream().mapToInt(i->i).sum(); average = sum/(double)numbers.size();
    }
    public void buildSummary() { summary = "Count:"+numbers.size()+" Sum:"+sum; processed=true; }
    public void export() throws Exception { bw = new java.io.BufferedWriter(new java.io.FileWriter("stats.txt")); bw.write(summary); bw.close(); }
    public boolean isProcessed() { return processed; }
}
