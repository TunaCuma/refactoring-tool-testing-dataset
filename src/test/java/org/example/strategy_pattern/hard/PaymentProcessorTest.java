package org.example.strategy_pattern.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentProcessorTest {
    @Test
    void testCreditCard() {
        PaymentProcessor proc = new PaymentProcessor();
        assertDoesNotThrow(() -> proc.processPayment("CREDIT_CARD", 100.0));
    }
    @Test
    void testUnknown() {
        PaymentProcessor proc = new PaymentProcessor();
        assertDoesNotThrow(() -> proc.processPayment("CASH", 50.0));
    }
}
