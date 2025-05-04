package org.example.long_method.medium;

public class NotificationManager {
    /**
     * Builds recipient list, composes messages via email/SMS/push, and logs results.
     */
    public java.util.List<String> sendBulkNotification(java.util.Map<String,String> users, String subject, String body) {
        java.util.List<String> results = new java.util.ArrayList<>();
        for (var entry : users.entrySet()) {
            String user = entry.getKey();
            String channel = entry.getValue();
            String res;
            if ("email".equalsIgnoreCase(channel)) {
                res = "Email to " + user + ": " + subject + " - " + body;
            } else if ("sms".equalsIgnoreCase(channel)) {
                res = "SMS to " + user + ": " + body;
            } else if ("push".equalsIgnoreCase(channel)) {
                res = "Push to " + user + ": " + subject;
            } else {
                res = "Unknown channel for " + user;
            }
            // simulate logging
            System.out.println("Sent: " + res);
            results.add(res);
        }
        return results;
    }
}
