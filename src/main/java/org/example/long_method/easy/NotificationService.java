package org.example.long_method.easy;

public class NotificationService {
    /**
     * Sends notifications to users by filtering preferences and formatting messages.
     */
    public java.util.List<String> notifyUsers(java.util.Map<String,Boolean> prefs, String message) {
        java.util.List<String> sent = new java.util.ArrayList<>();
        for (java.util.Map.Entry<String,Boolean> entry : prefs.entrySet()) {
            String user = entry.getKey();
            Boolean wants = entry.getValue();
            if (Boolean.TRUE.equals(wants)) {
                // simulate send
                sent.add("Sent to " + user + ": " + message);
            }
        }
        return sent;
    }
}
