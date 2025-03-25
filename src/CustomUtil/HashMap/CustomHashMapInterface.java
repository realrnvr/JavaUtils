package CustomUtil.HashMap;

public interface CustomHashMapInterface<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);

    V getOrDefault(K key, V defaultValue);
    void clear();
    boolean isEmpty();
    int size();
}
