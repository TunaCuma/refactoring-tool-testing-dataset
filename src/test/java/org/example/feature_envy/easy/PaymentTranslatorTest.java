package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PaymentTranslatorTest {
    @Test
    void testTranslate() {
        Payment p = new Payment(99.99, "USD");
        assertEquals("99.99 USD", new PaymentTranslator().translate(p));
    }
    @Test
    void testTranslateNull() {
        assertEquals("No payment", new PaymentTranslator().translate(null));
    }
}
