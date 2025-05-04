package org.example.long_method.medium;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class DataTransformerTest {
    @Test
    public void testTransform() {
        DataTransformer dt = new DataTransformer();
        Map<String, Integer> result = dt.transform(Arrays.asList(
            "a:10", "b:5", "a:-3", "c:foo", "", null
        ));

        // "a" -> 10 + (-3) = 7 (>=0), "b" -> 5; "c" skipped
        assertEquals(2, result.size());
        assertEquals(7, result.get("a"));
        assertEquals(5, result.get("b"));
        assertFalse(result.containsKey("c"));
    }
}
