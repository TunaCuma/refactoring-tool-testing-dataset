package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TransactionFeeCalculatorTest {
    @Test
    void testCalculateFees() {
        List<Transaction> list = Arrays.asList(
            new Transaction(100, "withdrawal"),
            new Transaction(200, "deposit"),
            new Transaction(50, "transfer"),
            null
        );
        TransactionBatch batch = new TransactionBatch(list);
        double fees = new TransactionFeeCalculator().calculateFees(batch);
        assertEquals(7.0, fees, 0.0001); // 2.5 + 2.0 + 2.5
    }
    @Test
    void testCalculateFeesEmpty() {
        assertEquals(0.0, new TransactionFeeCalculator().calculateFees(null));
        assertEquals(0.0, new TransactionFeeCalculator().calculateFees(new TransactionBatch(null)));
    }
}
