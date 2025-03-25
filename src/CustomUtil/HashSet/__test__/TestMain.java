package CustomUtil.HashSet.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomUtil.HashSet.CustomHashSet;

public class TestMain {
    private CustomHashSet<Integer> set;

    @BeforeEach
    void setUp() {
        set = new CustomHashSet<>();
    }

    @Test
    void testAdd() {
        assertTrue(set.add(10));  // Should return true (new element)
        assertFalse(set.add(10)); // Should return false (duplicate)
    }

    @Test
    void testContains() {
        set.add(5);
        set.add(15);
        assertTrue(set.contains(5));
        assertTrue(set.contains(15));
        assertFalse(set.contains(20)); // Not in the set
    }

    @Test
    void testRemove() {
        set.add(7);
        set.add(21);
        assertTrue(set.remove(7));  // Successfully removed
        assertFalse(set.contains(7)); // Should not be found after removal
        assertFalse(set.remove(100)); // Removing non-existing element should return false
    }

    @Test
    void testRemoveLastElement() {
        set.add(30);
        assertTrue(set.remove(30));
        assertFalse(set.contains(30));
    }

    @Test
    void testHandleCollisions() {
        set.add(1);
        set.add(17); // Assuming hash collision (for capacity 16)
        assertTrue(set.contains(1));
        assertTrue(set.contains(17));
        set.remove(1);
        assertFalse(set.contains(1));
        assertTrue(set.contains(17)); // Ensure 17 is still there
    }

    @Test
    void testNullKey() {
        assertTrue(set.add(null));  // Should allow null
        assertTrue(set.contains(null));
        assertTrue(set.remove(null));
        assertFalse(set.contains(null));
    }

    @Test
    void testResize() {
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        for (int i = 0; i < 20; i++) {
            assertTrue(set.contains(i));
        }
        assertEquals(20, set.size()); // Check correct size
    }

    @Test
    void testDuplicateAdd() {
        assertTrue(set.add(99));
        assertFalse(set.add(99)); // Should not add duplicate
        assertEquals(1, set.size()); // Size should remain 1
    }

    @Test
    void testEmptySet() {
        assertFalse(set.contains(42));
        assertFalse(set.remove(42)); // Should not remove non-existent element
    }
}

