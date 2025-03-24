package CustomUtil.ArrayList;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomArrayListInterface<T>{
    private Object[] data;
    private int size;
    private static final int DEFAULT_SIZE = 10;
    private static final int LOAD = 2;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public CustomArrayList(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    private void assignNewDataIfFull() {
        if(size == data.length) {
            Object[] newData = new Object[data.length * LOAD];
            System.arraycopy(data, 0, newData, 0, data.length);

            data = newData;
        }
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }

        StringBuilder res = new StringBuilder();
        res.append("[ ");

        for(int i = 0; i < size - 1; ++i) {
            res.append(data[i]).append(", ");
        }
        res.append(data[size - 1]).append(" ]");

        return res.toString();
    }

    private void isIndexInBound(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }

    /*
    * Adds element into the ArrayList
    * With O(1) TC
    * */
    public void add(T element) {
        assignNewDataIfFull();
        data[size++] = element;
    }

    /*
    * Adds element into the ArrayList
    * with the specified index
    * With O(n) TC
    * */
    public void add(int index, T element) {
        isIndexInBound(index);
        assignNewDataIfFull();

        for(int i = size; i > index; --i) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    /*
    * Retrieves element with the specified index
    * With O(1) TC
    *  */
    @SuppressWarnings("unchecked")
    public T get(int index) {
       isIndexInBound(index);
       return (T)(data[index]);
    }

    /*
    * Inserts an element into the ArrayList with the specified index
    * If an element is already present in that index
    * the element will get replaced with the specified element
    * With O(1) TC
    * */
    public void set(int index, T element) {
        isIndexInBound(index);
        data[index] = element;
    }

    /*
    * Removes the element from the specified index
    * with O(n) TC
    * */
    @SuppressWarnings("unchecked")
    public void remove(int index) {
        isIndexInBound(index);

        for(int i = index; i < size - 1; ++i) {
            T temp = (T)(data[i]);
            data[i] = data[i+1];
            data[i+1] = temp;
        }

        size--;
    }

    /*
    * Returns the size of the ArrayList
    * With O(1) TC
    * */
    public int size() {
        return size;
    }

    /*
    * Returns a boolean value
    * True if ArrayList is empty, otherwise false
    * With O(1) TC
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Returns a boolean value
    * True if ArrayList contains the specified element, otherwise false
    * With O(n) TC
    * */
    public boolean contains(T element) {
        for(int i = 0; i < size; ++i) {
            if(data[i] == element) {
                return true;
            }
        }

        return false;
    }

    /*
    * Returns the index of the specified element
    * If multiple occurrences of an element is present
    * Index of the first occurrence of that element will be returned
    * With O(n) TC
    * */
    public int indexOf(T element) {
        for(int i = 0; i < size; ++i) {
            if(data[i] == element) {
                return i;
            }
        }

        return -1;
    }

    /*
    * Removes every element present in the ArrayList
    * With O(n) TC
    * */
    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    /*
    * Pre-allocate ArrayList size with the provided capacity
    * With O(n) TC
    * */
    public void ensureCapacity(int newCapacity) {
        if(newCapacity <= data.length) {
            return;
        }

        Object[] newData = new Object[Math.max(newCapacity, data.length * LOAD)];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}
