package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BudgetAnalyzerTest {
    @Test
    void testIsOverBudgetTrue() {
        Project p = new Project(1000, new double[]{300, 400, 350});
        assertTrue(new BudgetAnalyzer().isOverBudget(p));
    }
    @Test
    void testIsOverBudgetFalse() {
        Project p = new Project(1200, new double[]{300, 400, 350});
        assertFalse(new BudgetAnalyzer().isOverBudget(p));
    }
}
