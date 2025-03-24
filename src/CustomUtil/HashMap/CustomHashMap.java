package CustomUtil.HashMap;

import org.jetbrains.annotations.NotNull;

public class CustomHashMap<K, V> {
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

    @NotNull
    private Integer hash(@NotNull K key) {
        return key.hashCode() % capacity;
    }

    @NotNull
    private Integer hash(@NotNull K key, int newCapacity) {
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

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> currNode = table[index];

        while (currNode != null) {
            if (currNode.key.equals(key)) {
                currNode.setValue(value);
                return;
            }

            currNode = currNode.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;

        size++;
        if(size > capacity * loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> currNode = table[index];

        while(currNode != null) {
            if(currNode.key.equals(key)) {
                return currNode.getValue();
            }

            currNode = currNode.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Node<K, V> currNode = table[index];
        Node<K, V> prevNode = null;

        while(currNode != null) {
            if(currNode.key.equals(key)) {
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
}
