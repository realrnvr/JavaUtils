package CustomUtil.Queue;
public class CustomQueue<E> implements CustomQueueInterface<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public CustomQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E element) {
            this(element, null);
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return this.element;
        }
    }

    /*
    * Checks whether the Queue is empty or not
    * Returns true if it does, Otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Adds element into the start of the Queue
    * With O(1) TC
    * */
    public void add(E element) {
        Node<E> newNode = new Node<>(element);

        if(isEmpty()) {
            head = tail = newNode;
            this.size++;
            return;
        }

        if(head == tail) {
            head.next = newNode;
            tail = newNode;
            this.size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /*
    * Remove and returns the element from the start of the Queue
    * With O(1) TC
    * */
    public E poll() {
        if(isEmpty()) {
            return null;
        }

        if(head == tail) {
            E element = head.getElement();
            head = tail = null;
            this.size--;
            return element;
        }

        E element = head.getElement();
        head = head.next;
        return element;
    }

    /*
    * Returns the element from the start of the Queue
    * With O(1) TC
    * */
    public E peek() {
        if(isEmpty()) {
            return null;
        }

        return this.head.getElement();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");

        Node<E> currNode = head;
        int count = 0;
        while(currNode != null) {
            res.append(currNode.getElement());
            if(++count < size) {
                res.append(", ");
            }

            currNode = currNode.next;
        }

        res.append("]");
        return res.toString();
    }
}
