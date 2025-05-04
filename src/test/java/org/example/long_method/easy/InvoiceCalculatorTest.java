package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class InvoiceCalculatorTest {
    @Test
    void testCalculateInvoice() {
        InvoiceCalculator calc = new InvoiceCalculator();
        double total = calc.calculateInvoice(Arrays.asList(100.0, 50.0), 0.2, 10.0);
        assertEquals(100+50 + (150*0.2) + 10.0, total);
    }

    @Test
    void testCalculateInvoiceEmpty() {
        InvoiceCalculator calc = new InvoiceCalculator();
        assertEquals(5.0, calc.calculateInvoice(Collections.emptyList(), 0.1, 5.0));
    }
}
