package org.example.strategy_pattern.medium;

public class NotificationSender {
    public String send(String channel, String message) {
        if ("EMAIL".equals(channel)) {
            return "Email sent: " + message;
        } else if ("SMS".equals(channel)) {
            return "SMS sent: " + message;
        } else if ("PUSH".equals(channel)) {
            return "Push notification: " + message;
        }
        throw new RuntimeException("Channel not supported: " + channel);
    }
}
