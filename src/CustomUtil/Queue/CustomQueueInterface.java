package CustomUtil.Queue;

public interface CustomQueueInterface<E> {
    void add(E element);
    E poll();
    E peek();

    boolean isEmpty();
}
