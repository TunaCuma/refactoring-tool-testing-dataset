package org.example.god_object.hard;

public class ApplicationService {
    private java.util.Map<String,String> sessions = new java.util.HashMap<>();
    private java.util.List<String> logs = new java.util.ArrayList<>();
    private java.sql.Connection conn;
    private final String dbUrl;
    private final int maxUsers;
    private java.io.FileWriter logWriter;
    private boolean active;
    private int requestCount;
    private java.util.Properties props = new java.util.Properties();
    private java.net.Socket socket;
    private String mode;

    public ApplicationService(String url, int max) { this.dbUrl=url; this.maxUsers=max; }
    public void start() throws Exception { props.load(new java.io.FileInputStream("service.properties")); conn=java.sql.DriverManager.getConnection(dbUrl); active=true; }
    public void stop() throws Exception { if(conn!=null) conn.close(); active=false; }
    public boolean isActive() { return active; }
    public String handleRequest(String user, String payload) throws Exception {
        if(requestCount++>maxUsers) throw new IllegalStateException("Too many users");
        sessions.put(user, payload);
        logEvent(user, payload);
        return "OK:"+payload;
    }
    private void logEvent(String user, String payload) throws Exception {
        if(logWriter==null) logWriter=new java.io.FileWriter("app.log", true);
        logWriter.write(user+":"+payload+"\n");
    }
    public java.util.Map<String,String> getSessions() { return sessions; }
}
