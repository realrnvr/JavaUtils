package CustomUtil.HashMap.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import CustomUtil.HashMap.CustomHashMap;

public class TestMain {

    @Test
    void testPutAndGet() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertNull(map.get("three"));  // Key does not exist
    }

    @Test
    void testPutOverwrite() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("one", 10);  // Overwriting existing key

        assertEquals(10, map.get("one"));  // Value should be updated
    }

    @Test
    void testRemove() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        map.remove("one");
        assertNull(map.get("one"));  // Should be removed
        assertEquals(2, map.get("two"));  // Other key should remain
    }

    @Test
    void testContainsKey() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);

        assertTrue(map.containsKey("one"));
        assertFalse(map.containsKey("two"));
    }

    @Test
    void testContainsValue() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);

        assertTrue(map.containsValue(2));
        assertFalse(map.containsValue(99));
    }

    @Test
    void testResize() {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();

        // Insert more elements than the initial capacity to trigger resize
        for (int i = 0; i < 20; i++) {
            map.put(i, "Value" + i);
        }

        assertEquals("Value19", map.get(19));
        assertEquals("Value0", map.get(0)); // Old keys should still exist
    }

    @Test
    void testNullKey() {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put(null, 100);

        assertEquals(100, map.get(null));  // Should handle null keys correctly
    }
}

