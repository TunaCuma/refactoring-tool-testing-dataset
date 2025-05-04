package org.example.long_method.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
class CustomerPrinterTest {
    @Test
    void testPrintCustomerFull() {
        CustomerPrinter cp = new CustomerPrinter();
        Map<String,String> info = new HashMap<>();
        info.put("name","Jane"); info.put("address","123 St"); info.put("email","jane@example.com");
        List<String> hist = Arrays.asList("order1","order2");
        String output = cp.printCustomer(info, hist);
        assertTrue(output.contains("Name: Jane"));
        assertTrue(output.contains("Order History:"));
        assertTrue(output.contains("- order1"));
    }

    @Test
    void testPrintCustomerEmptyHistory() {
        CustomerPrinter cp = new CustomerPrinter();
        Map<String,String> info = new HashMap<>();
        info.put("name","Sam");
        String output = cp.printCustomer(info, Collections.emptyList());
        assertTrue(output.contains("Address: N/A"));
        assertTrue(output.contains("(none)"));
    }
}
