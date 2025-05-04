package org.example.feature_envy.medium;

public class AddressFormatter {
    /**
     * Formats a customer's address into a single string.
     */
    public String format(CustomerA customer) {
        if (customer == null) return "";
        return customer.getStreet() + ", " +
               customer.getCity() + " " +
               customer.getPostalCode() + ", " +
               customer.getCountry();
    }
}

class CustomerA {
    private final String street, city, postalCode, country;
    public CustomerA(String street, String city, String postalCode, String country) {
        this.street = street; this.city = city;
        this.postalCode = postalCode; this.country = country;
    }
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
}
