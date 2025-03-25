package CustomUtil.LinkedList.__test__;

import static org.junit.jupiter.api.Assertions.*;

import CustomUtil.LinkedList.CustomLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMain {
    private CustomLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CustomLinkedList<>();
    }

    @Test
    void testAddAndSize() {
        assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtIndex() {
        list.add(10);
        list.add(30);
        list.add(1, 20); // Adding at index 1
        assertEquals(20, list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    void testAddFirstAndAddLast() {
        list.addFirst(10);
        list.addLast(30);
        list.addFirst(5);
        assertEquals(5, list.getFirst());
        assertEquals(30, list.getLast());
    }

    @Test
    void testRemoveByValue() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertTrue(list.remove((Integer) 20)); // Removing existing element
        assertEquals(2, list.size());
        assertFalse(list.remove((Integer) 100)); // Element not present
    }

    @Test
    void testRemoveByIndex() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1)); // Removing element at index 1
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirstAndLast() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.removeFirst());
        assertEquals(30, list.removeLast());
    }

    @Test
    void testRemoveFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        assertThrows(IndexOutOfBoundsException.class, list::removeFirst);
        assertThrows(IndexOutOfBoundsException.class, list::removeLast);
    }

    @Test
    void testRemoveInvalidIndex() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void testGetElement() {
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testContains() {
        list.add(10);
        list.add(20);
        assertTrue(list.contains(10));
        assertFalse(list.contains(99));
    }

    @Test
    void testClearAndIsEmpty() {
        list.add(10);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}
