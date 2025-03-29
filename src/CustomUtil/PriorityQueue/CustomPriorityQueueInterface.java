package CustomUtil.PriorityQueue;

public interface CustomPriorityQueueInterface<E> {
    void add(E element);
    E peek();
    E poll();
    boolean isEmpty();
}
