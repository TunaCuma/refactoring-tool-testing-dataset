package org.example.feature_envy.medium;

public class EmailValidator {
    /**
     * Validates an Email object's components.
     */
    public boolean isValid(Email e) {
        if (e == null) return false;
        String local = e.getLocalPart(), domain = e.getDomain();
        if (local == null || domain == null) return false;
        return local.length() > 0 && !local.contains(" ") &&
               domain.contains(".") && !domain.startsWith(".");
    }
}

class Email {
    private final String localPart, domain;
    public Email(String localPart, String domain) {
        this.localPart = localPart; this.domain = domain;
    }
    public String getLocalPart() { return localPart; }
    public String getDomain() { return domain; }
}
