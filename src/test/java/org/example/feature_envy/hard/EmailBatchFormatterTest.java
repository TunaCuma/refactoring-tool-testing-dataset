package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class EmailBatchFormatterTest {
    @Test
    void testFormatBatch() {
        List<Email> list = Arrays.asList(
            new Email("a@b.com","Hi","Hello"),
            new Email("c@d.com","Hi2","Hello2"),
            null
        );
        EmailBatch batch = new EmailBatch(list);
        String res = new EmailBatchFormatter().formatBatch(batch);
        assertTrue(res.contains("To: a@b.com"));
        assertTrue(res.contains("Subject: Hi2"));
        assertTrue(res.contains("----"));
    }
    @Test
    void testFormatEmpty() {
        assertEquals("No emails", new EmailBatchFormatter().formatBatch(null));
        assertEquals("No emails", new EmailBatchFormatter().formatBatch(new EmailBatch(new ArrayList<>())));
    }
}
