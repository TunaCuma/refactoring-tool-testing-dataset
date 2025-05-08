package org.example.god_object.easy;

public class NotificationManager {
    private java.util.List<String> sent = new java.util.ArrayList<>();

    public void sendEmail(String email, String message) {
        sent.add("EMAIL:" + email + ":" + message);
    }

    public void sendSMS(String number, String message) {
        sent.add("SMS:" + number + ":" + message);
    }

    public void scheduleNotification(String id, java.time.LocalDateTime time) {
        sent.add("SCHEDULED:" + id + "@" + time);
    }

    public void cancelNotification(String id) {
        sent.removeIf(s -> s.contains(id));
    }

    public java.util.List<String> getSent() {
        return sent;
    }
}
