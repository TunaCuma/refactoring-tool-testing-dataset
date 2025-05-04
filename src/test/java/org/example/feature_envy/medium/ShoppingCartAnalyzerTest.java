package org.example.feature_envy.medium;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ShoppingCartAnalyzerTest {
    @Test
    void testAnalyze() {
        Cart cart = new Cart(List.of(
            new CartItem("A", 10.0, 2),
            new CartItem("B", 5.0, 3)
        ));
        assertEquals("Items: 5, Total: 35.00", new ShoppingCartAnalyzer().analyze(cart));
    }
    @Test
    void testAnalyzeEmptyOrNull() {
        assertEquals("Empty cart", new ShoppingCartAnalyzer().analyze(null));
        assertEquals("Empty cart", new ShoppingCartAnalyzer().analyze(new Cart(List.of())));
    }
}
