package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AnalyticsDashboardTest {
    @Test
    void testGenerateUserReportEmpty() {
        AnalyticsDashboard dash = new AnalyticsDashboard();
        String json = dash.generateUserReport();
        assertTrue(json.contains("{}"));
    }
}
