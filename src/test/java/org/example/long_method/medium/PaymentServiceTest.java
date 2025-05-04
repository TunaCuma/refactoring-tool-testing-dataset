package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentServiceTest {
    @Test
    void testValidVisaPayment() {
        String res = new PaymentService().processPayment("4123456789012", 100.0, "a@b.com");
        assertTrue(res.contains("Transaction:"));
        assertTrue(res.contains("Receipt sent to: a@b.com"));
    }
    @Test
    void testInsufficientFunds() {
        assertEquals("Insufficient funds.", new PaymentService().processPayment("4123456789012345", 2000.0, null));
    }
    @Test
    void testInvalidCard() {
        assertThrows(IllegalArgumentException.class, () -> new PaymentService().processPayment(null, 50.0, null));
    }
}
