package org.example.feature_envy.hard;

import java.util.*;

public class EmailBatchFormatter {
    /**
     * Formats a batch of emails into one string separated by delimiters.
     */
    public String formatBatch(EmailBatch batch) {
        if (batch == null || batch.getEmails() == null || batch.getEmails().isEmpty()) {
            return "No emails";
        }
        StringBuilder sb = new StringBuilder();
        for (Email e : batch.getEmails()) {
            if (e == null) continue;
            sb.append("To: ").append(e.getRecipient()).append("\n")
              .append("Subject: ").append(e.getSubject()).append("\n")
              .append(e.getBody()).append("\n")
              .append("----\n");
        }
        return sb.toString().trim();
    }
}

class EmailBatch {
    private final List<Email> emails;
    public EmailBatch(List<Email> emails) { this.emails = emails; }
    public List<Email> getEmails() { return emails; }
}

class Email {
    private final String recipient, subject, body;
    public Email(String recipient, String subject, String body) {
        this.recipient = recipient; this.subject = subject; this.body = body;
    }
    public String getRecipient() { return recipient; }
    public String getSubject() { return subject; }
    public String getBody() { return body; }
}
