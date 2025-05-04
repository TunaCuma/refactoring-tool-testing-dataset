package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class WorkHoursCalculatorTest {
    @Test
    void testTotalHoursNormal() {
        Timesheet t = new Timesheet(new int[]{8, 7, 9, 10});
        // caps daily to 8 on overtime days: 8+7+8+8 = 31
        assertEquals(31, new WorkHoursCalculator().totalHours(t));
    }
    @Test
    void testTotalHoursEmptyOrNull() {
        assertEquals(0, new WorkHoursCalculator().totalHours(null));
        assertEquals(0, new WorkHoursCalculator().totalHours(new Timesheet(new int[0])));
    }
}
