package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class GodClassExampleTest {
    @Test
    void testCompute() { GodClassExample g = new GodClassExample(); assertEquals(5, g.compute(2,3)); }
    @Test
    void testFlagDefault() { GodClassExample g = new GodClassExample(); assertFalse(g.checkFlag()); }
}
