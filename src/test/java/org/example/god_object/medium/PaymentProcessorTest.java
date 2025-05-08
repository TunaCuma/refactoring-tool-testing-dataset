package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentProcessorTest {
    @Test
    void testProcessValid() {
        PaymentProcessor pp = new PaymentProcessor();
        String res = pp.process(50.0, "card");
        assertTrue(res.contains("\"status\":\"ok\""));
    }

    @Test
    void testProcessInvalid() {
        PaymentProcessor pp = new PaymentProcessor();
        assertThrows(IllegalArgumentException.class, () -> pp.process(0, "card"));
    }
}
