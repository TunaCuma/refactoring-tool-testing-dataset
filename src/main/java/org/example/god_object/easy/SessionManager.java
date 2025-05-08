package org.example.god_object.easy;

public class SessionManager {
    private java.util.Map<String, java.time.LocalDateTime> sessions = new java.util.HashMap<>();

    public String createSession(String user) {
        String id = java.util.UUID.randomUUID().toString();
        sessions.put(id, java.time.LocalDateTime.now());
        return id;
    }

    public boolean validateSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public java.time.LocalDateTime getSessionInfo(String sessionId) {
        return sessions.get(sessionId);
    }
}
