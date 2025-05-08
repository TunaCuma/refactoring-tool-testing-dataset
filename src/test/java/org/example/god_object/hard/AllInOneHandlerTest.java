package org.example.god_object.hard;

import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class AllInOneHandlerTest {
    @Test
    void testQueueAndStore() throws Exception {
        AllInOneHandler h = new AllInOneHandler();
        h.enqueue("x"); assertEquals("x", h.dequeue());
        h.storeData("k","v"); assertEquals("v", h.retrieve("k"));
    }
    @Test
    void testPrepareReady() throws Exception { AllInOneHandler h = new AllInOneHandler(); h.prepare("tmp.txt"); assertTrue(h.ready); }
}
