package org.example.god_object.hard;

public class MegaDashboard {
    private java.util.List<String> widgets = new java.util.ArrayList<>();
    private java.util.Map<String,Object> context = new java.util.HashMap<>();
    private java.awt.Frame awtFrame;
    private int refreshRate;
    private java.time.LocalDateTime lastRefresh;
    private java.util.Properties dashProps = new java.util.Properties();
    private java.io.File dashFile = new java.io.File("dash.cfg");
    private boolean visible;
    private java.io.BufferedReader reader;
    private java.io.BufferedWriter writer;
    private java.net.URL dataUrl;

    public void loadConfig() throws Exception { dashProps.load(new java.io.FileInputStream(dashFile)); refreshRate=Integer.parseInt(dashProps.getProperty("rate")); }
    public void connect() throws Exception { reader = new java.io.BufferedReader(new java.io.FileReader(dashFile)); }
    public void refresh() throws Exception { lastRefresh = java.time.LocalDateTime.now(); }
    public void render() { visible=true; awtFrame.repaint(); }
    public void saveState() throws Exception { writer=new java.io.BufferedWriter(new java.io.FileWriter("state.dat")); writer.write(context.toString()); writer.close(); }
    public void close() { if(writer!=null) try{writer.close();}catch(Exception e){} }
    public boolean isVisible() { return visible; }
}
