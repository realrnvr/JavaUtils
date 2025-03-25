package CustomUtil.ArrayList.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomUtil.ArrayList.CustomArrayList;

class TestMain {
    private CustomArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    void testAddAndGet() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddAtIndex() {
        list.add(10);
        list.add(30);
        list.add(1, 20);  // Insert at index 1
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(10);
        assertEquals(1, list.size());
        list.add(20);
        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.remove(1));  // Remove middle element
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));  // Ensure shifting works
    }

    @Test
    void testRemoveFirstAndLast() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.remove(0));  // Remove first
        assertEquals(30, list.remove(list.size() - 1));  // Remove last
    }

    @Test
    void testOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testAddNull() {
        list.add(null);
        assertNull(list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void testResize() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100, list.size());
        assertEquals(99, list.get(99));
    }

    @Test
    void testSet() {
        list.add(10);
        list.add(20);
        list.set(1, 99);
        assertEquals(99, list.get(1));
    }

    @Test
    void testContains() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertTrue(list.contains(20));
        assertFalse(list.contains(50));
    }

    @Test
    void testIndexOf() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(1, list.indexOf(20));
        assertEquals(-1, list.indexOf(50));
    }

    @Test
    void testClear() {
        list.add(10);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}

