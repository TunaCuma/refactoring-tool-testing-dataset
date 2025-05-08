package org.example.god_object.easy;

public class UserService {
    private java.util.Map<String, String> users = new java.util.HashMap<>();
    private java.util.Set<String> activeUsers = new java.util.HashSet<>();

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (!users.containsKey(username)) return false;
        boolean ok = users.get(username).equals(password);
        if (ok) activeUsers.add(username);
        return ok;
    }

    public void deactivateUser(String username) {
        activeUsers.remove(username);
        users.remove(username);
    }

    public boolean isActive(String username) {
        return activeUsers.contains(username);
    }
}
