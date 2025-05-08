package org.example.strategy_pattern.easy;

public class NotificationSender {
    /**
     * Sends notifications based on channel.
     */
    public String send(String channel, String message) {
        String output;
        switch (channel) {
            case "EMAIL":
                output = "Email sent: " + message;
                break;
            case "SMS":
                output = "SMS sent: " + message;
                break;
            case "PUSH":
                output = "Push notification: " + message;
                break;
            default:
                output = "Channel not supported: " + channel;
                break;
        }
        return output;
    }
}
