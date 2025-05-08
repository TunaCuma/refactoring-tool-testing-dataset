package org.example.god_object.hard;

public class GodClassExample {
    private java.util.List<String> listA = new java.util.ArrayList<>();
    private java.util.List<Integer> listB = new java.util.ArrayList<>();
    private java.util.Map<String,String> mapC = new java.util.HashMap<>();
    private java.util.Properties p = new java.util.Properties();
    private java.sql.Connection conn;
    private java.net.URL url;
    private java.io.File file;
    private int x;
    private boolean flag;
    private java.util.Date date;
    private java.io.BufferedReader br;

    public void actionOne() throws Exception { }
    public int compute(int a,int b) { return a+b; }
    public void transform() { }
    public void updateDB() throws Exception { conn.createStatement().execute("UPDATE T SET C=1"); }
    public void loadFile() throws Exception { br=new java.io.BufferedReader(new java.io.FileReader(file)); }
    public String buildMessage() { return "Value:"+x; }
    public boolean checkFlag() { return flag; }
    public void clearAll() { listA.clear(); listB.clear(); mapC.clear(); }
    public void setDate(java.util.Date d) { date=d; }
    public java.util.Date getDate() { return date; }
}
