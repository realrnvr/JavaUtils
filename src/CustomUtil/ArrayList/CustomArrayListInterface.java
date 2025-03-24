package CustomUtil.ArrayList;

public interface CustomArrayListInterface<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void remove(int index);
    int size();
    boolean isEmpty();
    boolean contains(T element);
    int indexOf(T element);
    void clear();
}
