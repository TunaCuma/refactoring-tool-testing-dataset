package org.example.long_method.easy;

public class UserManager {
    /**
     * Registers and authenticates users in-memory, returns status.
     */
    private java.util.Map<String,String> db = new java.util.HashMap<>();

    public String handleUser(String action, String username, String password) {
        StringBuilder sb = new StringBuilder();
        // 1. Register
        if ("register".equalsIgnoreCase(action)) {
            if (db.containsKey(username)) sb.append("User exists.");
            else {
                db.put(username, password);
                sb.append("Registered ").append(username);
            }
        }
        // 2. Login
        else if ("login".equalsIgnoreCase(action)) {
            if (!db.containsKey(username)) sb.append("No such user.");
            else if (!db.get(username).equals(password)) sb.append("Wrong password.");
            else sb.append("Welcome ").append(username);
        } else sb.append("Unknown action.");
        return sb.toString();
    }
}
