package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountCheckerTest {
    @Test
    void testEligible() {
        Customer c = new Customer(new double[]{1200, 1100, 1300}, 600);
        assertTrue(new DiscountChecker().isEligible(c));
    }
    @Test
    void testNotEligibleLowAvg() {
        Customer c = new Customer(new double[]{800, 900, 950}, 700);
        assertFalse(new DiscountChecker().isEligible(c));
    }
    @Test
    void testNotEligibleLowPoints() {
        Customer c = new Customer(new double[]{1500, 1600}, 400);
        assertFalse(new DiscountChecker().isEligible(c));
    }
    @Test
    void testEligibleNullOrEmpty() {
        assertFalse(new DiscountChecker().isEligible(null));
        assertFalse(new DiscountChecker().isEligible(new Customer(new double[0], 1000)));
    }
}
