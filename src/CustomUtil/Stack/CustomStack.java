package CustomUtil.Stack;

public class CustomStack<E> implements CustomStackInterface<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private final E element;
        Node<E> next;

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
    * Adds element into the Stack
    * At the top
    * With O(1) TC
    * */
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        if(head == null) {
            this.head = newNode;
            this.size++;
            return;
        }

        newNode.next = head;
        this.head = newNode;
        this.size++;
    }

    /*
    * Removes top element from the Stack
    * With O(1) TC
    * */
    public E pop() {
        if(isEmpty()) {
            return null;
        }

        E element = head.getElement();
        this.head = head.next;
        this.size--;
        return element;
    }

    /*
    * Retrieves the top element from the Stack
    * With O(1) TC
    * */
    public E peek() {
        if(isEmpty()) {
            return null;
        }

        return head.getElement();
    }

    /*
    * Checks if the Stack is empty or not
    * return true if it does, Otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Returns the size of the Stack
    * */
    public int size() {
        return this.size;
    }

    /*
    * Removes every element from the Stack
    * */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /*
    * Checks if the specified element exists in the Stack Or not
    * Returns true if it does, Otherwise false
    * With O(n) TC
    * */
    public boolean contains(E element) {
        if(isEmpty()) {
            return false;
        }

        Node<E> currNode = head;
        while(currNode.next != null) {
            if(currNode.element.equals(element)) {
                return true;
            }

            currNode = currNode.next;
        }

        return false;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "[]";
        }

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
