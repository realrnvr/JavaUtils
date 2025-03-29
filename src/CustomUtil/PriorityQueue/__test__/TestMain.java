package CustomUtil.PriorityQueue.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import CustomUtil.PriorityQueue.CustomPriorityQueue;

public class TestMain {
    @Test
    void testAddAndPeek() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(2);
        pq.add(8);
        pq.add(1);


        assertEquals(1, pq.peek(), "Peek should return the smallest element.");
    }

    @Test
    void testPoll() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        assertEquals(1, pq.poll(), "Poll should return the smallest element first.");
        assertEquals(2, pq.poll(), "Next smallest element should be polled.");
        assertEquals(5, pq.poll(), "Followed by 5.");
        assertEquals(8, pq.poll(), "Followed by 8.");
        assertNull(pq.poll(), "Polling an empty queue should return null.");
    }

    @Test
    void testIsEmpty() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertTrue(pq.isEmpty(), "Queue should be empty initially.");

        pq.add(10);
        assertFalse(pq.isEmpty(), "Queue should not be empty after adding an element.");

        pq.poll();
        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testAddingDuplicates() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(3);
        pq.add(3);
        pq.add(3);

        assertEquals(3, pq.poll(), "Poll should return 3.");
        assertEquals(3, pq.poll(), "Poll should return 3 again.");
        assertEquals(3, pq.poll(), "Poll should return 3 again.");
        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testMixOfOperations() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(15);
        pq.add(5);

        assertEquals(5, pq.poll(), "First poll should return 5.");
        pq.add(1);
        assertEquals(1, pq.poll(), "Poll should return the newly added smallest element.");
        assertEquals(10, pq.poll(), "Poll should return 10.");
        assertEquals(15, pq.poll(), "Poll should return 15.");
        assertTrue(pq.isEmpty(), "Queue should be empty at the end.");
    }

    @Test
    void testLargeNumberOfElements() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();

        // Add 10,000 elements in descending order
        for (int i = 10000; i > 0; i--) {
            pq.add(i);
        }

        // Poll elements and ensure they are in increasing order
        for (int i = 1; i <= 10000; i++) {
            assertEquals(i, pq.poll(), "Polling should return elements in sorted order.");
        }

        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testNegativeNumbers() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(-10);
        pq.add(-20);
        pq.add(-5);
        pq.add(0);

        assertEquals(-20, pq.poll(), "Poll should return the smallest negative number first.");
        assertEquals(-10, pq.poll(), "Poll should return -10 next.");
        assertEquals(-5, pq.poll(), "Poll should return -5.");
        assertEquals(0, pq.poll(), "Poll should return 0.");
        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testRandomOrderInserts() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        int[] numbers = {42, 1, 56, 3, 99, 10, 7, 32, 5};

        for (int num : numbers) {
            pq.add(num);
        }

        int[] expectedOrder = {1, 3, 5, 7, 10, 32, 42, 56, 99};
        for (int expected : expectedOrder) {
            assertEquals(expected, pq.poll(), "Polling should return elements in sorted order.");
        }

        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testAlternatingInsertPoll() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(10);
        pq.add(20);
        assertEquals(10, pq.poll(), "Poll should return 10.");
        pq.add(5);
        assertEquals(5, pq.poll(), "Poll should return 5.");
        pq.add(15);
        assertEquals(15, pq.poll(), "Poll should return 15.");
        assertEquals(20, pq.poll(), "Poll should return 20.");
        assertTrue(pq.isEmpty(), "Queue should be empty at the end.");
    }

    @Test
    void testEdgeCaseSingleElement() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        pq.add(100);
        assertEquals(100, pq.poll(), "Poll should return the only element present.");
        assertTrue(pq.isEmpty(), "Queue should be empty after polling the only element.");
    }

    @Test
    void testEdgeCaseEmptyPoll() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertNull(pq.poll(), "Polling an empty queue should return null.");
    }

    @Test
    void testEdgeCasePeekOnEmptyQueue() {
        CustomPriorityQueue<Integer> pq = new CustomPriorityQueue<>();
        assertNull(pq.peek(), "Peeking an empty queue should return null.");
    }
}
