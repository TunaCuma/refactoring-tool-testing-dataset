package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InvoiceCalculatorTest {
    @Test
    void testCalculateLateFee() {
        Invoice invoice = new Invoice(5, 200.0);
        InvoiceCalculator calc = new InvoiceCalculator();
        assertEquals(5 * 200.0 * 0.01, calc.calculateLateFee(invoice));
    }
    @Test
    void testCalculateLateFeeNull() {
        InvoiceCalculator calc = new InvoiceCalculator();
        assertEquals(0.0, calc.calculateLateFee(null));
    }
}
