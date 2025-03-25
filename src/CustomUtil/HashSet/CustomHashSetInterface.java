package CustomUtil.HashSet;

public interface CustomHashSetInterface<E> {
    boolean add(E element);
    void clear();
    boolean contains(E element);
    boolean remove(E element);
    boolean isEmpty();
    int size();
}
