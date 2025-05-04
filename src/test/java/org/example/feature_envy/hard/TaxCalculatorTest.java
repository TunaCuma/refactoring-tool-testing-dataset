package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TaxCalculatorTest {
    @Test
    void testCalculateTax() {
        List<TaxBracket> brackets = Arrays.asList(
            new TaxBracket(1000, 0.1),
            new TaxBracket(2000, 0.2)
        );
        TaxInfo info = new TaxInfo(2500, brackets);
        assertEquals(400.0, new TaxCalculator().calculateTax(info), 0.0001);
    }
    @Test
    void testCalculateTaxEmpty() {
        assertEquals(0.0, new TaxCalculator().calculateTax(null));
        assertEquals(0.0, new TaxCalculator().calculateTax(new TaxInfo(1000, null)));
    }
}
