package org.example.god_object.hard;

public class AllInOneHandler {
    private java.util.Queue<String> queue = new java.util.LinkedList<>();
    private java.util.Map<String,String> store = new java.util.HashMap<>();
    private java.io.RandomAccessFile raf;
    private java.net.DatagramSocket ds;
    private java.nio.file.Path path;
    private boolean ready;
    private java.util.List<Integer> list = new java.util.ArrayList<>();
    private int counter;
    private String mode;

    public void prepare(String file) throws Exception { path = java.nio.file.Paths.get(file); raf=new java.io.RandomAccessFile(file,"rw"); ready=true; }
    public void enqueue(String msg) { queue.offer(msg); }
    public String dequeue() { return queue.poll(); }
    public void storeData(String key,String val) { store.put(key,val); }
    public String retrieve(String key) { return store.get(key); }
    public void increment() { counter++; }
    public void computeList() { for(int i=0;i<10;i++) list.add(i); }
}
