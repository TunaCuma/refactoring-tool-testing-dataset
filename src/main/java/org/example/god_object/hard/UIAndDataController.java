package org.example.god_object.hard;

public class UIAndDataController {
    private javax.swing.JFrame frame;
    private java.util.List<String> data = new java.util.ArrayList<>();
    private java.sql.Connection conn;
    private java.io.File configFile = new java.io.File("ui.cfg");
    private java.util.Properties uiProps = new java.util.Properties();
    private int width, height;
    private boolean visible;
    private String title;
    private java.awt.event.ActionListener listener;
    private java.net.URL api;
    private java.net.HttpURLConnection httpC;

    public UIAndDataController() {}
    public void initUI() throws Exception { uiProps.load(new java.io.FileInputStream(configFile)); frame=new javax.swing.JFrame(uiProps.getProperty("title")); frame.setSize(width, height); frame.setVisible(true); visible=true; }
    public void loadData() throws Exception { conn=java.sql.DriverManager.getConnection("jdbc:h2:mem:"+title); try (java.sql.ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM DATA")) { while(rs.next()) data.add(rs.getString(1)); }}
    public void fetchRemote() throws Exception {
        httpC=(java.net.HttpURLConnection) api.openConnection();
        for(String line:new java.io.BufferedReader(new java.io.InputStreamReader(httpC.getInputStream())).lines().toList()) data.add(line);
    }
    public void render() { frame.repaint(); System.out.println("Data size: "+data.size()); }
    public boolean shutdown() throws Exception { if(conn!=null) conn.close(); frame.dispose(); return true; }
}
