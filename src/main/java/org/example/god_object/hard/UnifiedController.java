package org.example.god_object.hard;

public class UnifiedController {
    private java.util.List<String> commands = new java.util.ArrayList<>();
    private java.util.Map<String,String> responses = new java.util.HashMap<>();
    private java.util.Properties props = new java.util.Properties();
    private java.io.File file;
    private java.net.Socket sock;
    private boolean connected;
    private String endpoint;
    private int timeout;
    private java.io.BufferedReader reader;
    private java.io.BufferedWriter writer;

    public UnifiedController(String ep,int t) { this.endpoint=ep; this.timeout=t; }
    public void connect() throws Exception { sock=new java.net.Socket(endpoint, timeout); connected=true; }
    public String sendCommand(String cmd) throws Exception { if(!connected) connect(); writer=new java.io.BufferedWriter(new java.io.OutputStreamWriter(sock.getOutputStream())); writer.write(cmd); writer.flush(); reader=new java.io.BufferedReader(new java.io.InputStreamReader(sock.getInputStream())); return reader.readLine(); }
    public void record(String cmd,String resp) { commands.add(cmd); responses.put(cmd,resp); }
    public void close() throws Exception { if(sock!=null) sock.close(); connected=false; }
}
