package org.example.feature_envy.easy;

public class EmailComposer {
    /**
     * Builds a greeting email header using user info.
     */
    public String composeGreeting(User u) {
        if (u == null) return "Hello, Guest";
        return "Hello, " + u.getFirstName() + " " + u.getLastName();
    }
}

class User {
    private final String firstName;
    private final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
