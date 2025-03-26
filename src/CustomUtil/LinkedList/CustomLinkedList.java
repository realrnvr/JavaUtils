package CustomUtil.LinkedList;

public class CustomLinkedList<E> implements CustomLinkedListInterface<E> {
    private Node<E> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }
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
    * Adds element in the last position of the LinkedList
    * With O(n) TC
    * */
    public void add(E element) {
        Node<E> newNode = new Node<>(element);

        if(head == null) {
            head = newNode;
            size++;
            return;
        }

        Node<E> currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
        size++;
    }

    /*
    * Adds element into the specified index of the LinkedList
    * With O(n) TC
    * */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        Node<E> currNode = head;
        Node<E> prevNode = null;

        while(index > 0) {
            prevNode = currNode;
            currNode = currNode.next;
            index--;
        }

        Node<E> newNode = new Node<>(element);
        if(prevNode == null) {
            newNode.next = head;
            head = newNode;
        } else {
            prevNode.next = newNode;
            newNode.next = currNode;
        }

        size++;
    }

    /*
    * Adds element at the start of the LinkedList
    * With O(1) TC
    * */
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /*
    * Adds element at the end of the LinkedList
    * With O(n) TC
    * */
    public void addLast(E element) {
        Node<E> currNode = head;

        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = new Node<>(element);
        size++;
    }

    /*
    * Removes first occurrence of the specified element
    * from the LinkedList
    * With O(n) TC
    * */
    public boolean remove(E element) {
        if (isEmpty()) {
            return false;
        }

        Node<E> currNode = head;
        Node<E> prevNode = null;

        while (currNode != null && !currNode.element.equals(element)) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            return false;
        }

        if (prevNode == null) {
            head = head.next;
        } else {
            prevNode.next = currNode.next;
        }

        size--;
        return true;
    }

    /*
    * Removes the element from the specified index
    * From the LinkedList
    * With O(n) TC
    * */
    public E remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> currNode = head;
        Node<E> prevNode = null;

        while(index > 0) {
            prevNode = currNode;
            currNode = currNode.next;
            index--;
        }

        if(prevNode == null) {
            E element = head.getElement();
            this.head = null;
            this.size = 0;
            return element;
        }

        E element = currNode.getElement();
        prevNode.next = currNode.next;
        size--;
        return element;
    }

    /*
    * Removes first element from the LinkedList
    * With O(1) TC
    * */
    public E removeFirst() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        E element = head.element;
        head = head.next;
        size--;
        return element;
    }

    /*
    * Removes last element from the LinkedList
    * With O(n) TC
    * */
    public E removeLast() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        Node<E> currNode = head;
        Node<E> prevNode = null;

        while(currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if(prevNode == null) {
            E element = head.getElement();
            this.head = null;
            this.size = 0;
            return element;
        }

        E element = currNode.getElement();
        prevNode.next = null;
        size--;
        return element;
    }

    /*
    * Retrieves the element at the index specified
    * From the LinkedList
    * Return null is the element is not present in the LinkedList
    * With O(n) TC
    * */
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }

        Node<E> currNode = head;
        while(index > 0) {
            currNode = currNode.next;
            index--;
        }

        return currNode.getElement();
    }

    /*
    * Retrieves the first element from the LinkedList
    * With O(1) TC
    * */
    public E getFirst() {
        if(isEmpty()) {
            return null;
        }

        return this.head.getElement();
    }

    /*
    * Retrieves last element from the LinkedList
    * With O(n) TC
    * */
    public E getLast() {
        if(isEmpty()) {
            return null;
        }

        Node<E> currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        return currNode.getElement();
    }

    /*
    * Checks whether the LinkedList is empty or not
    * return true if it does, Otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Returns the size of the LinkedList
    * */
    public int size() {
        return this.size;
    }

    /*
    * Removes all the elements from the LinkedList
    * */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /*
    * Checks if the element specified contains in the LinkedList or not
    * Return true if it does, Otherwise false
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
        res.append("[ ");

        int count = 0;
        Node<E> currNode = head;
        while(currNode.next != null) {
            res.append(currNode.getElement());
            if(++count > size) {
                res.append(", ");
            }

            currNode = currNode.next;
        }

        res.append(" ]");
        return res.toString();
    }
}
