package org.example.god_object.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentHandlerTest {
    @Test
    void testInitiateAndStatus() {
        PaymentHandler ph = new PaymentHandler();
        String id = ph.initiatePayment("acct1", 50.0);
        assertEquals("PENDING", ph.getPaymentStatus(id));
    }
    @Test
    void testValidateAndRefund() {
        PaymentHandler ph = new PaymentHandler();
        String id = ph.initiatePayment("acct2", 75.0);
        assertTrue(ph.validatePayment(id));
        assertTrue(ph.refund(id));
        assertEquals("REFUNDED", ph.getPaymentStatus(id));
    }
}
