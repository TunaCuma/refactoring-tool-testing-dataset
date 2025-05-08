package org.example.god_object.medium;

public class NotificationManager {
    private Connection connection;

    public NotificationManager() {
        try { connection = DriverManager.getConnection("jdbc:h2:mem:testdb"); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public void notifyUsers(List<String> users, String message) {
        for (String user : users) {
            sendPushNotification(user, message);
            logNotification(user, message);
            saveNotificationRecord(user, message);
        }
    }

    private void sendPushNotification(String user, String msg) {
        System.out.println("Push sent to " + user + ": " + msg);
    }

    private void logNotification(String user, String msg) {
        System.out.println("Logged notification for " + user);
    }

    private void saveNotificationRecord(String user, String msg) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO NOTIFICATIONS(USER,MESSAGE) VALUES(?,?)")) {
            ps.setString(1, user);
            ps.setString(2, msg);
            ps.execute();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
