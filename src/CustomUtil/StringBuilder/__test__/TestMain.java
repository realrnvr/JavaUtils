package CustomUtil.StringBuilder.__test__;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomUtil.StringBuilder.CustomStringBuilder;

public class TestMain {
    private CustomStringBuilder sb;

    @BeforeEach
    void setup() {
        sb = new CustomStringBuilder();
    }

    @Test
    void testAppend() {
        sb.append("Hello");
        assertEquals("Hello", sb.toString(), "Appending a string should store it correctly.");

        sb.append(" World");
        assertEquals("Hello World", sb.toString(), "Appending another string should concatenate correctly.");

        sb.append('!');
        assertEquals("Hello World!", sb.toString(), "Appending a char should work correctly.");
    }

    @Test
    void testDelete() {
        sb.append("Hello World");

        sb.delete(5, 11);
        assertEquals("Hello", sb.toString(), "Deleting a range should remove the specified characters.");

        sb.delete(0, 2);
        assertEquals("llo", sb.toString(), "Deleting from start should work correctly.");

        sb.delete(2, 3);
        assertEquals("ll", sb.toString(), "Deleting the last character should work correctly.");
    }

    @Test
    void testInsert() {
        sb.append("Helo");

        sb.insert(2, 'l');
        assertEquals("Hello", sb.toString(), "Inserting a character at index should work.");

        sb.insert(5, " World");
        assertEquals("Hello World", sb.toString(), "Inserting a string should work.");

        sb.insert(0, "Start ");
        assertEquals("Start Hello World", sb.toString(), "Inserting at the beginning should work.");
    }

    @Test
    void testReverse() {
        sb.append("abcd");
        sb.reverse();
        assertEquals("dcba", sb.toString(), "Reversing a string should return the correct order.");

        sb.clear();
        sb.append("racecar");
        sb.reverse();
        assertEquals("racecar", sb.toString(), "Reversing a palindrome should return the same string.");
    }

    @Test
    void testClear() {
        sb.append("Some text");
        sb.clear();
        assertEquals("", sb.toString(), "Clearing should remove all content.");
        assertTrue(sb.isEmpty(), "Builder should be empty after clearing.");
    }

    @Test
    void testLength() {
        assertEquals(0, sb.length(), "New builder should have length 0.");

        sb.append("Hello");
        assertEquals(5, sb.length(), "Length should be correct after append.");

        sb.delete(1, 3);
        assertEquals(3, sb.length(), "Length should adjust correctly after deletion.");
    }

    @Test
    void testEdgeCases() {
        sb.append("");
        assertEquals("", sb.toString(), "Appending an empty string should not change content.");

        sb.append("Test");
        sb.delete(0, sb.length());
        assertEquals("", sb.toString(), "Deleting entire content should result in empty builder.");

        sb.insert(0, "");
        assertEquals("", sb.toString(), "Inserting an empty string should not change content.");
    }

    @Test
    void testReplaceSingleCharacter() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Hello");

        sb.replace(1, 2, "a");  // Replace "e" with "a"
        assertEquals("Hallo", sb.toString(), "Replacing single character failed.");
    }

    @Test
    void testReplaceSubstringWithShorterString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Hello World");

        sb.replace(6, 11, "Mars");  // Replace "World" with "Mars"
        assertEquals("Hello Mars", sb.toString(), "Replacing a substring with a shorter string failed.");
    }

    @Test
    void testReplaceSubstringWithLongerString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Hi there");

        sb.replace(3, 8, "everyone");  // Replace "there" with "everyone"
        assertEquals("Hi everyone", sb.toString(), "Replacing a substring with a longer string failed.");
    }

    @Test
    void testReplaceFullString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("OldString");

        sb.replace(0, sb.length(), "NewString");  // Replace entire string
        assertEquals("NewString", sb.toString(), "Replacing the full string failed.");
    }

    @Test
    void testReplaceWithEmptyString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("RemoveMe");

        sb.replace(0, 8, "");  // Remove all characters
        assertEquals("", sb.toString(), "Replacing with an empty string should clear the range.");
    }

    @Test
    void testReplaceSameStartAndEndIndex() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Test");

        sb.replace(2, 2, "Insert");  // Insert "Insert" at index 2
        assertEquals("TeInsertst", sb.toString(), "Inserting a string with replace() failed.");
    }

    @Test
    void testReplaceWithTrimmedEnd() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Short");  // "Short" (length 5)

        sb.replace(2, 10, "New");  // Since 10 > length(5), end should be trimmed to 5

        assertEquals("ShNew", sb.toString(), "End index should be trimmed to size");
    }

    @Test
    void testLargeAppend() {
        CustomStringBuilder sb = new CustomStringBuilder();
        int largeSize = 1_000_000; // 1 million characters
        for (int i = 0; i < largeSize; i++) {
            sb.append('a');
        }
        assertEquals(largeSize, sb.length(), "Length should match the number of appended characters");
    }

    @Test
    void testLargeInsert() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("A".repeat(500_000)); // Start with 500K 'A's
        sb.insert(250_000, "Hello"); // Insert in the middle
        assertEquals(500_005, sb.length(), "Length should account for inserted characters");
        assertEquals('H', sb.charAt(250_000), "Inserted text should start with 'H'");
    }

    @Test
    void testLargeDelete() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("B".repeat(1_000_000)); // 1 million 'B's
        sb.delete(100_000, 900_000); // Remove the middle 800K
        assertEquals(200_000, sb.length(), "Length should be 200K after deletion");
        assertEquals('B', sb.charAt(99_999), "Remaining characters should be correct");
        assertEquals('B', sb.charAt(100_000), "Deletion should start at correct index");
    }

    @Test
    void testRepeatedReplace() {
        CustomStringBuilder sb = new CustomStringBuilder("XXXXX".repeat(200_000)); // 1M chars
        for (int i = 0; i < 10; i++) {
            sb.replace(0, 5, "YYYYY"); // Replace first 5 chars each iteration
        }
        assertEquals('Y', sb.charAt(0), "First character should be 'Y'");
        assertEquals('Y', sb.charAt(4), "Fifth character should be 'Y'");
    }

    @Test
    void testLargeReverse() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("1234567890".repeat(100_000)); // 1 million characters
        sb.reverse();
        assertEquals('0', sb.charAt(0), "First character after reversal should be '0'");
        assertEquals('1', sb.charAt(sb.length() - 1), "Last character after reversal should be '1'");
    }
}
