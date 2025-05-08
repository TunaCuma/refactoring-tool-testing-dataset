package org.example.god_object.medium;

public class UserProfileManager {
    private Map<String, String> profiles = new HashMap<>();

    public void updateProfile(String user, String data) {
        validate(user, data);
        encryptData(data);
        profiles.put(user, data);
        logChange(user);
    }

    public String getProfile(String user) {
        return profiles.get(user);
    }

    private void validate(String u, String d) {
        if (u == null || d == null) throw new IllegalArgumentException();
    }

    private void encryptData(String d) {
        System.out.println("Encrypting data");
    }

    private void logChange(String u) {
        System.out.println("Profile updated for " + u);
    }
}
