package CustomUtil.PriorityQueue.MaxHeap.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import CustomUtil.PriorityQueue.MaxHeap.CustomMaxHeapPriorityQueue;

public class TestMain {
    @Test
    void testAddAndPeek() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(5);
        pq.add(30);

        assertEquals(30, pq.peek(), "Peek should return the largest element.");
    }

    @Test
    void testPoll() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        pq.add(5);
        pq.add(15);
        pq.add(25);
        pq.add(10);

        assertEquals(25, pq.poll(), "Poll should return the largest element first.");
        assertEquals(15, pq.poll(), "Next largest element should be polled.");
        assertEquals(10, pq.poll(), "Followed by 10.");
        assertEquals(5, pq.poll(), "Followed by 5.");
        assertNull(pq.poll(), "Polling an empty queue should return null.");
    }

    @Test
    void testIsEmpty() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        assertTrue(pq.isEmpty(), "Queue should be empty initially.");

        pq.add(42);
        assertFalse(pq.isEmpty(), "Queue should not be empty after adding an element.");

        pq.poll();
        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testAddingDuplicates() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        pq.add(7);
        pq.add(7);
        pq.add(7);

        assertEquals(7, pq.poll(), "Poll should return 7.");
        assertEquals(7, pq.poll(), "Poll should return 7 again.");
        assertEquals(7, pq.poll(), "Poll should return 7 again.");
        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }

    @Test
    void testMixOfOperations() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        pq.add(50);
        pq.add(40);
        pq.add(30);

        assertEquals(50, pq.poll(), "First poll should return 50.");
        pq.add(60);
        assertEquals(60, pq.poll(), "Poll should return the newly added largest element.");
        assertEquals(40, pq.poll(), "Poll should return 40.");
        assertEquals(30, pq.poll(), "Poll should return 30.");
        assertTrue(pq.isEmpty(), "Queue should be empty at the end.");
    }

    @Test
    void testLargeDataSet() {
        CustomMaxHeapPriorityQueue<Integer> pq = new CustomMaxHeapPriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
        }

        for (int i = 1000; i >= 1; i--) {
            assertEquals(i, pq.poll(), "Poll should return the largest remaining element.");
        }

        assertTrue(pq.isEmpty(), "Queue should be empty after polling all elements.");
    }
}
