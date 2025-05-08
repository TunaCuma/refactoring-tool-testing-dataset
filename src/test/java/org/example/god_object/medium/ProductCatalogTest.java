package org.example.god_object.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ProductCatalogTest {
    @Test
    void testSearchEmpty() {
        ProductCatalog pc = new ProductCatalog();
        pc.loadProducts();
        assertTrue(pc.search("x").isEmpty());
    }
}
