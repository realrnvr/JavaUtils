package CustomUtil.Stack.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomUtil.Stack.CustomStack;


public class TestMain {

    private CustomStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new CustomStack<>();
    }

    @Test
    void testPushAndSize() {
        assertEquals(0, stack.size());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop()); // LIFO
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty()); // Stack should be empty now
    }

    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.peek()); // Should return the last pushed element
        assertEquals(3, stack.size()); // Size should remain the same
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty()); // Should be empty again
    }

    @Test
    void testClear() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testContains() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertTrue(stack.contains(20));
        assertFalse(stack.contains(99)); // Element not in stack
    }

    @Test
    void testPopOnEmptyStack() {
        assertTrue(stack.isEmpty());
        assertNull(stack.pop()); // Should return null (or throw an exception if you implemented that)
    }

    @Test
    void testPeekOnEmptyStack() {
        assertTrue(stack.isEmpty());
        assertNull(stack.peek()); // Should return null (or throw an exception)
    }

    @Test
    void testToString() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals("[30, 20, 10]", stack.toString()); // Stack prints top-to-bottom order
    }
}

