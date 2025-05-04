package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PaymentSummaryGeneratorTest {
    @Test
    void testGenerateMultiple() {
        List<Payment> list = Arrays.asList(
            new Payment(100, "USD"),
            new Payment(50, "EUR"),
            new Payment(200, "USD"),
            null
        );
        PaymentData data = new PaymentData(list);
        String result = new PaymentSummaryGenerator().generateSummary(data);
        assertTrue(result.contains("USD: count=2, total=300.00, avg=150.00"));
        assertTrue(result.contains("EUR: count=1, total=50.00, avg=50.00"));
    }
    @Test
    void testGenerateEmpty() {
        assertEquals("No payments available",
            new PaymentSummaryGenerator().generateSummary(null));
        assertEquals("No payments available",
            new PaymentSummaryGenerator().generateSummary(new PaymentData(new ArrayList<>())));
    }
}
