package org.example.god_object.hard;

public class MasterHandler {
    private java.util.List<String> tasks = new java.util.ArrayList<>();
    private java.util.Map<String,Boolean> status = new java.util.HashMap<>();
    private java.io.File config;
    private java.util.Properties props = new java.util.Properties();
    private boolean running;
    private java.net.ServerSocket ss;
    private java.io.BufferedReader br;
    private java.io.BufferedWriter bw;
    private java.time.LocalDateTime startTime;
    private int maxTasks;

    public MasterHandler() {}
    public void loadConfig() throws Exception { props.load(new java.io.FileInputStream(config)); maxTasks=Integer.parseInt(props.getProperty("max")); }
    public void addTask(String t) { if(tasks.size()<maxTasks) tasks.add(t); status.put(t,false); }
    public void executeAll() { for(String t:tasks) status.put(t,true); running=true; startTime=java.time.LocalDateTime.now(); }
    public boolean isRunning() { return running; }
}
