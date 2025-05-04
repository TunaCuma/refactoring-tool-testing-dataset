package org.example.feature_envy.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AccountReporterTest {
    @Test
    void testGenerateReport() {
        Account a = new Account("A123", 500.75);
        assertEquals("Account A123 has balance 500.75", new AccountReporter().generateReport(a));
    }
    @Test
    void testGenerateReportNull() {
        assertEquals("No account", new AccountReporter().generateReport(null));
    }
}
