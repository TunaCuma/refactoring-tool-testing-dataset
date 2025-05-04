package org.example.long_method.easy;

public class CustomerPrinter {
    /**
     * Prints customer details by assembling name, address, and order history.
     */
    public String printCustomer(java.util.Map<String, String> info, java.util.List<String> history) {
        // 1. Header
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Details:\n");
        // 2. Info fields
        for (String key : new String[]{"name", "address", "email"}) {
            String value = info.get(key);
            sb.append(key.substring(0,1).toUpperCase()).append(key.substring(1))
              .append(": ")
              .append(value == null ? "N/A" : value)
              .append("\n");
        }
        // 3. Order history
        sb.append("Order History:\n");
        if (history == null || history.isEmpty()) {
            sb.append("(none)\n");
        } else {
            for (String order : history) {
                sb.append("- ").append(order).append("\n");
            }
        }
        // 4. Footer
        sb.append("----- End -----");
        return sb.toString();
    }
}
