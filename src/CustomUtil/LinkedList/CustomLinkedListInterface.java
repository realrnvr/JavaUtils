package CustomUtil.LinkedList;

public interface CustomLinkedListInterface<E> {
    void add(E element);
    void add(int index, E element);
    void addFirst(E element);
    void addLast(E element);

    E remove(int index);
    boolean remove(E element);
    E removeFirst();
    E removeLast();

    E get(int index);
    E getFirst();
    E getLast();

    boolean contains(E element);
    int size();
    boolean isEmpty();
    void clear();
}
