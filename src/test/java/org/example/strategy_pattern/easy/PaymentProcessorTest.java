package org.example.strategy_pattern.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {
    @Test
    void testCalculateFeeCredit() {
        PaymentProcessor proc = new PaymentProcessor();
        assertEquals(2.0, proc.calculateFee("CREDIT", 100.0));
    }

    @Test
    void testCalculateFeeDefault() {
        PaymentProcessor proc = new PaymentProcessor();
        assertEquals(5.0, proc.calculateFee("UNKNOWN", 100.0));
    }
}
