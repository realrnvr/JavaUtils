package CustomUtil.PriorityQueue;

public interface CustomProrityQueueInterface<E> {
    void add(E element);
    E peek();
    E poll();
    boolean isEmpty();
}
