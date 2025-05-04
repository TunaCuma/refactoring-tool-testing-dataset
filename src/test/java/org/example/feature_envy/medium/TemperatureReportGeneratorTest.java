package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TemperatureReportGeneratorTest {
    @Test
    void testReport() {
        WeatherData wd = new WeatherData(new double[]{-5.0, 0.0, 15.5, 10.0});
        assertEquals("Low: -5.0, High: 15.5", new TemperatureReportGenerator().report(wd));
    }
    @Test
    void testReportNoData() {
        assertEquals("No temperatures", new TemperatureReportGenerator().report(null));
        assertEquals("No temperatures", new TemperatureReportGenerator().report(new WeatherData(new double[0])));
    }
}
