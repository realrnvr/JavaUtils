package CustomUtil.Queue.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomUtil.Queue.CustomQueue;

class TestMain {
    private CustomQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new CustomQueue<>(); // Assuming default constructor initializes an empty queue
    }

    @Test
    void testAddAndPoll() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.poll()); // FIFO order check
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
    }

    @Test
    void testPeek() {
        queue.add(10);
        assertEquals(10, queue.peek()); // Ensure front element is correct
        assertEquals(10, queue.peek()); // Peek should NOT remove the element
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.add(100);
        assertFalse(queue.isEmpty());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPollOnEmptyQueue() {
        assertNull(queue.poll()); // Should return null instead of throwing an exception
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertNull(queue.peek()); // Should return null instead of throwing an exception
    }

    @Test
    void testPrintingLine() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        assertEquals("[1, 2, 3, 4]", queue.toString(), "Queue string representation should match expected output.");
    }
}
