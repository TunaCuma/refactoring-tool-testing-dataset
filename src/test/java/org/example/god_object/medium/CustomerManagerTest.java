package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CustomerManagerTest {
    @Test
    void testAddCustomerValid() {
        CustomerManager mgr = new CustomerManager();
        mgr.addCustomer("Alice");
        assertEquals(1, mgr.getCustomerCount());
    }

    @Test
    void testAddCustomerInvalid() {
        CustomerManager mgr = new CustomerManager();
        assertThrows(IllegalArgumentException.class, () -> mgr.addCustomer(""));
    }
}
