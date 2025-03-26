package CustomUtil.Stack;

public interface CustomStackInterface<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
    void clear();
    boolean contains(E element);
}
