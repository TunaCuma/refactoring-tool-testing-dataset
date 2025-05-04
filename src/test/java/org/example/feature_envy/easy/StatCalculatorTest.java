package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StatCalculatorTest {
    @Test
    void testAverage() {
        Student s = new Student(new double[]{80, 90, 100});
        assertEquals(90.0, new StatCalculator().average(s));
    }
    @Test
    void testAverageNull() {
        assertEquals(0.0, new StatCalculator().average(null));
    }
}
