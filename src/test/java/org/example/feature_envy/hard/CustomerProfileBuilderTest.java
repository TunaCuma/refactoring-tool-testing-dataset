package org.example.feature_envy.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CustomerProfileBuilderTest {
    @Test
    void testBuildWithOrders() {
        Customer c = new Customer("John", "Doe", "123 Elm St");
        List<Order> orders = Arrays.asList(new Order("Book",2), new Order("Pen",5));
        CustomerData data = new CustomerData(c, orders);
        String result = new CustomerProfileBuilder().buildProfile(data);
        assertTrue(result.contains("Name: John Doe"));
        assertTrue(result.contains("Address: 123 Elm St"));
        assertTrue(result.contains("- Book: 2"));
        assertTrue(result.contains("- Pen: 5"));
    }
    @Test
    void testBuildNoOrders() {
        Customer c = new Customer("Jane","Smith","456 Oak Ave");
        String profile = new CustomerProfileBuilder().buildProfile(new CustomerData(c, Collections.emptyList()));
        assertTrue(profile.contains("No orders"));
    }
    @Test
    void testBuildNullData() {
        assertEquals("No customer data",
            new CustomerProfileBuilder().buildProfile(null));
    }
}
