package org.example.strategy_pattern.hard;

public class NotificationService {
    public void notifyUser(String channel, String message) {
        if (channel.equals("EMAIL")) {
            System.out.println("Sending email: " + message);
        } else if (channel.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        } else if (channel.equals("PUSH")) {
            System.out.println("Sending push notification: " + message);
        } else if (channel.equals("SLACK")) {
            System.out.println("Sending Slack message: " + message);
        } else {
            System.out.println("Unknown channel: " + channel);
        }
    }
}
