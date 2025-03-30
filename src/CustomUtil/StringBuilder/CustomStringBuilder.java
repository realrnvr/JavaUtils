package CustomUtil.StringBuilder;

public class CustomStringBuilder implements CustomStringBuilderInterface {
    private static final int DEFAULT_SIZE = 16;
    private static final float INCREMENT_SIZE_BY = 1.5f;

    private char[] data;
    private int size;

    public CustomStringBuilder() {
        this.data = new char[DEFAULT_SIZE];
        this.size = 0;
    }

    public CustomStringBuilder(int capacity) throws IllegalArgumentException {
        if(capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be less than zero");
        }

        this.data = new char[Math.max(capacity, (int)(DEFAULT_SIZE * INCREMENT_SIZE_BY))];
        this.size = 0;
    }

    public CustomStringBuilder(String string) {
        if(string == null) {
            return;
        }

        this.data = new char[Math.max(string.length(), (int)(DEFAULT_SIZE * INCREMENT_SIZE_BY))];

        for(int i = 0; i < string.length(); ++i) {
            this.data[size++] = string.charAt(i);
        }
    }

    private void resize() {
        if(size >= data.length) {
            char[] newData = new char[(int)(size * INCREMENT_SIZE_BY)];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    /*
    * Adds char at the last place in the String Builder
    * With O(1) TC
    * */
    public void append(char character) {
        resize();
        this.data[size++] = character;
    }

    /*
    * Adds the specified String at the last place of the String Builder
    * With O(len) TC : [len is equal to the length of the specified String]
    * */
    public void append(String string) {
        if(string == null) {
            return;
        }

        for(int i = 0; i < string.length(); ++i) {
            resize();
            this.data[size++] = string.charAt(i);
        }
    }

    /*
    * Inserts the String at the specified index into the String Builder
    * With O(2n + len) TC : [len is the length of the specified String]
    * */
    public void insert(int index, String string) throws IndexOutOfBoundsException {
        if(string == null) {
            return;
        }

        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        char[] nextChar = new char[size - index];
        for(int i = index; i < size; ++i) {
            nextChar[i - index] = data[i];
        }

        this.size += string.length();
        resize();

        int i = index;
        int strLength = string.length();
        while(strLength-- > 0) {
            data[i] = string.charAt(i - index);
            i++;
        }

        i = string.length() + index;
        int nextCharSize = nextChar.length;
        while(nextCharSize-- > 0) {
            data[i] = nextChar[i - string.length() - index];
            i++;
        }
    }

    /*
    * Inserts the char at the specified index of the String Builder
    * With O(2n) TC
    * */
    public void insert(int index, char character) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        char[] nextChar = new char[size - index];
        for(int i = index; i < size; ++i) {
            nextChar[i - index] = data[i];
        }

        this.size += 1;
        resize();
        data[index] = character;

        int i = index + 1;
        int nextCharSize = nextChar.length;
        while(nextCharSize-- > 0) {
            data[i] = nextChar[i - index - 1];
            i++;
        }
    }

    /*
    * Deletes char sequence from the specified starting index to the ending index of the String Builder
    * With O(n) TC
    * */
    public void delete(int start, int end) throws IndexOutOfBoundsException {
        if(start < 0 || start > size || start > end) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        if(end > size) {
            end = size;
        }

        if(start == size || start == end) {
            return;
        }

        while(end < size) {
            data[start++] = data[end++];
        }

        this.size -= end - start;
    }

    /*
    * Deletes the char at the specified index of the String Builder
    * With O(n) TC
    * */
    public void deleteCharAt(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        for(int i = index; i < size - 1; ++i) {
            data[i] = data[i+1];
        }

        this.size--;
    }

    /*
    * Replaces the char sequence from the specified starting index to the ending index with the specified
    * String of the String Builder
    * With O(2n + len) TC : [len is the length of the specified String]
    * */
    public void replace(int start, int end, String string) throws IndexOutOfBoundsException {
        if(start < 0 || start > size || start > end) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        if(string == null) {
            return;
        }

        if(end > size) {
            end = size;
        }

        char[] nextChar = new char[size - end];
        for(int i = end; i < size; ++i) {
            nextChar[i - end] = data[i];
        }

        this.size += string.length() - (end - start);
        resize();

        int i = start;
        int strLength = string.length();
        while(strLength-- > 0) {
            data[i] = string.charAt(i - start);
            i++;
        }

        i = string.length() + start;
        int nextCharSize = nextChar.length;
        while(nextCharSize-- > 0) {
            data[i] = nextChar[i - string.length() - start];
            i++;
        }
    }

    /*
    * Returns the char present on the specified index of the String Builder
    * With O(1) TC
    * */
    public char charAt(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        return data[index];
    }

    /*
    * Returns the size of the String Builder
    * */
    public int length() {
        return size;
    }

    @Override
    public String toString() {
        return new String(data, 0, size);
    }

    /*
    * Reverses the String Builder
    * With O(n / 2) TC
    * */
    public void reverse() {
        int start = 0;
        int end = size - 1;

        while(start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }

    /*
    * Returns true if the String Builder is empty, Otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Clears the String Builder
    * */
    public void clear() {
        this.size = 0;
    }
}
