package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TemperatureConverterTest {
    @Test
    void testToFahrenheit() {
        Weather w = new Weather(0);
        assertEquals(32.0, new TemperatureConverter().toFahrenheit(w));
    }
    @Test
    void testToFahrenheitNull() {
        assertTrue(Double.isNaN(new TemperatureConverter().toFahrenheit(null)));
    }
}
