package org.example.feature_envy.hard;

import java.util.*;

public class CustomerProfileBuilder {
    /**
     * Builds a profile summary including name, address, and recent orders.
     */
    public String buildProfile(CustomerData data) {
        if (data == null || data.getCustomer() == null) {
            return "No customer data";
        }
        Customer c = data.getCustomer();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(c.getFirstName()).append(" ").append(c.getLastName()).append("\n");
        sb.append("Address: ").append(c.getAddress()).append("\n");
        List<Order> orders = data.getOrders();
        if (orders == null || orders.isEmpty()) {
            sb.append("No orders\n");
        } else {
            sb.append("Orders:\n");
            for (Order o : orders) {
                sb.append("- ").append(o.getItem()).append(": ").append(o.getQuantity()).append("\n");
            }
        }
        return sb.toString().trim();
    }
}

class CustomerData {
    private final Customer customer;
    private final List<Order> orders;
    public CustomerData(Customer customer, List<Order> orders) {
        this.customer = customer; this.orders = orders;
    }
    public Customer getCustomer() { return customer; }
    public List<Order> getOrders() { return orders; }
}

class Customer {
    private final String firstName, lastName, address;
    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName; this.lastName = lastName; this.address = address;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
}

class Order {
    private final String item;
    private final int quantity;
    public Order(String item, int quantity) {
        this.item = item; this.quantity = quantity;
    }
    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
}
