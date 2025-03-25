package CustomUtil.HashMap;

public class CustomHashMap<K, V> implements CustomHashMapInterface<K, V>{
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private final float loadFactor;
    private int size;
    private Node<K, V>[] table;

    public CustomHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
        this.table = (Node<K, V>[])(new Node[capacity]);
    }

    private static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return this.value;
        }

        public K getKey() {
            return this.key;
        }
    }

    private int hash(K key) {
        if(key == null) {
            return 0;
        }

        return key.hashCode() % capacity;
    }

    private int hash(K key, int newCapacity) {
        if(key == null) {
            return 0;
        }

        return key.hashCode() % newCapacity;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Node<K, V>[] newTable = (Node<K, V>[])(new Node[newCapacity]);

        for(int i = 0; i < capacity; ++i) {
            Node<K, V> currNode = table[i];

            while(currNode != null) {
                Node<K, V> nextNode = currNode.next;
                int index = hash(currNode.key, newCapacity);
                currNode.next = newTable[index];
                newTable[index] = currNode;
                currNode = nextNode;
            }

            table = newTable;
            capacity = newCapacity;
        }
    }

    @Override
    public String toString() {
        if(size == 0) {
            return "{}";
        }

        StringBuilder res = new StringBuilder();

        res.append("{ ");
        for(int i = 0; i < size - 1; ++i) {
            if(table[i] != null) {
                res.append(table[i].getKey()).append(" => ").append(table[i].getValue()).append(", ");
            }
        }

        if(table[size - 1] != null) {
            res.append(table[size - 1].getKey()).append(" => ").append(table[size - 1].getValue()).append(" }");
        }

        return res.toString();
    }

    /*
    * Puts key-value pair in to the HashMap
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) TC : [using tree buckets]
    * */
    public void put(K key, V value) {
        int index = hash(key);

        if(table[index] == null) {
            table[index] = new Node<>(key, value, null);
            size++;
            return;
        }

        Node<K, V> currNode = table[index];

        while (currNode != null) {
            if((currNode.key == null && key == null) || (currNode.key != null && currNode.key.equals(key))) {
                currNode.setValue(value);
                return;
            }

            currNode = currNode.next;
        }

        table[index] = new Node<>(key, value, table[index]);

        size++;
        if(size > capacity * loadFactor) {
            resize();
        }
    }

    /*
    * Retrieves the value related to the key
    * If the key is not present in the HashMap, null will be returned
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) : [using tree buckets]
    * */
    public V get(K key) {
        int index = hash(key);

        if(table[index] == null) {
            return null;
        }

        Node<K, V> currNode = table[index];

        while(currNode != null) {
            if((currNode.key == null && key == null) || (currNode.key != null && currNode.key.equals(key))) {
                return currNode.getValue();
            }

            currNode = currNode.next;
        }

        return null;
    }

    /*
    * Removes the key-value pair in the HashMap
    * which corresponds to the specified key
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) : [using tree buckets]
    * */
    public void remove(K key) {
        int index = hash(key);

        if(table[index] == null) return;

        Node<K, V> currNode = table[index];
        Node<K, V> prevNode = null;

        while(currNode != null) {
            if((currNode.key == null && key == null) || (currNode.key != null && currNode.key.equals(key))) {
                if(prevNode == null) {
                    table[index] = currNode.next;
                } else {
                    prevNode.next = currNode.next;
                }

                size--;
                return;
            }

            prevNode = currNode;
            currNode = currNode.next;
        }
    }

    /*
    * Checks if the specified key is present in the HashMap or not
    * True if present, otherwise false
    * With best and average O(1) TC
    * With worst O(n) TC : [due to hash collision]
    * For Java 8+, worst O(log n) : [using tree buckets]
    *  */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /*
     * Checks if the specified key is present in the HashMap or not
     * True if present, otherwise false
     * With O(n) TC
     * */
    public boolean containsValue(V value) {
        for(int i = 0; i < capacity; ++i) {
            Node<K, V> currNode = table[i];

            while(currNode != null) {
                if(currNode.value.equals(value)) {
                    return true;
                }

                currNode = currNode.next;
            }
        }

        return false;
    }

    /*
     * Checks if the specified key is present in the HashMap
     * If it does then it will return its corresponding value, otherwise
     * Fallbacks to the default value which is specified
     * With best and average O(1) TC
     * With worst O(n) TC : [due to hash collision]
     * For Java 8+, worst O(log n) : [using tree buckets]
     *  */
    public V getOrDefault(K key, V defaultValue) {
        V value = get(key);

        return value == null ? defaultValue : value;
    }

    /*
    * Removes all the key-value pairs from the HashMap
    * */
    public void clear() {
        for(int i = 0; i < capacity; ++i) {
            table[i] = null;
        }

        this.size = 0;
    }

    /*
    * Checks if the HashMap is empty or not
    * returns true if it does, otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Returns the size of the HashMap
    * */
    public int size() {
        return this.size;
    }
}
