package org.example.feature_envy.medium;

public class NotificationBuilder {
    /**
     * Builds a notification string from a notification object.
     */
    public String build(Notification n) {
        if (n == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("To: ").append(n.getRecipientEmail()).append("\n");
        sb.append("Subject: ").append(n.getTitle()).append("\n");
        sb.append("Body: ").append(n.getMessage());
        return sb.toString();
    }
}

class Notification {
    private final String recipientEmail, title, message;
    public Notification(String recipientEmail, String title, String message) {
        this.recipientEmail = recipientEmail;
        this.title = title;
        this.message = message;
    }
    public String getRecipientEmail() { return recipientEmail; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
}
