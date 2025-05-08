package org.example.strategy_pattern.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentProcessorTest {
    @Test
    void testCreditCard() {
        PaymentProcessor proc = new PaymentProcessor();
        assertTrue(proc.processPayment("CREDIT_CARD", 100).startsWith("Processed credit card"));
    }
    @Test
    void testUnsupportedMethod() {
        PaymentProcessor proc = new PaymentProcessor();
        assertThrows(UnsupportedOperationException.class, () -> proc.processPayment("CASH", 50));
    }
}
