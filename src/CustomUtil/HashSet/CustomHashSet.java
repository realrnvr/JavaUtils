package CustomUtil.HashSet;

public class CustomHashSet<E> implements CustomHashSetInterface<E>{
    private static final int DEFAULT_SIZE = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private final float loadFactor;
    private Node<E>[] table;
    private int size;

    public CustomHashSet() {
        this(DEFAULT_SIZE, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public CustomHashSet(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.table = (Node<E>[])(new Node[capacity]);
        this.size = 0;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this(element, null);
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    private int hash(E element) {
        return element == null ? 0 : Math.abs(element.hashCode() % capacity);
    }

    private int hash(E element, int newCapacity) {
        return element == null ? 0 : Math.abs(element.hashCode() % newCapacity);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Node<E>[] newTable = (Node<E>[])(new Node[newCapacity]);

        for(int i = 0; i < capacity; ++i) {
            Node<E> currNode = table[i];

            while(currNode != null) {
                Node<E> nextNode = currNode.next;
                int index = hash(currNode.element, newCapacity);
                currNode.next = newTable[index];
                newTable[index] = currNode;
                currNode = nextNode;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    /*
    * Adds an element to the set if it is not already present.
    * If the element already exists, it will not be added again.
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) TC : [using tree buckets]
    * */
    public boolean add(E element) {
        int index = hash(element);

        if(table[index] == null) {
            table[index] = new Node<>(element, table[index]);
            size++;
            return true;
        }

        Node<E> currNode = table[index];

        while(currNode != null) {
            if((currNode.element == null && element == null)
                    || (currNode.element != null && currNode.element.equals(element))) {
                return false;
            }

            currNode = currNode.next;
        }

        table[index] = new Node<>(element, table[index]);

        this.size++;
        if(size > capacity * loadFactor) {
            resize();
        }

        return true;
    }

    /*
    * Removes all the elements from the HashSet
    * */
    public void clear() {
        for(int i = 0; i < capacity; ++i) {
            table[i] = null;
        }

        this.size = 0;
    }

    /*
    * Checks if the specified element is present in the HashSet or not
    * If it does present returns true, otherwise false
     * With best and average O(1) TC
     * With worst O(n) TC : [due to hash collision]
     * For Java 8+, worst O(log n) TC : [using tree buckets]
    * */
    public boolean contains(E element) {
        int index = hash(element);
        Node<E> currNode = table[index];

        while(currNode != null) {
            if((currNode.element == null && element == null) ||
                    (currNode.element != null && currNode.element.equals(element))) {
                return true;
            }

            currNode = currNode.next;
        }

        return false;
    }

    /*
    * Removes the specified element from the HashSet
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) TC : [using tree buckets]
    * */
    public boolean remove(E element) {
        int index = hash(element);
        if(table[index] == null) return false;

        Node<E> currNode = table[index];
        Node<E> prevNode = null;

        while(currNode != null) {
            if((currNode.element == null && element == null) || (currNode.element != null && currNode.element.equals(element))) {
                if(prevNode == null) {
                    table[index] = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }

                this.size--;
                return true;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }

        return false;
    }

    /*
    * Checks if the HashSet is empty or not
    * returns true if it does, otherwise false
    * */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
    * Returns the size of the HashSet
    * */
    public int size() {
        return this.size;
    }
}
