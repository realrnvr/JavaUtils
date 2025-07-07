package CustomUtil.PriorityQueue.MinHeap;

import CustomUtil.ArrayList.CustomArrayList;
import CustomUtil.Queue.CustomQueueInterface;

public class CustomMinHeapPriorityQueue<E extends Comparable<E>> implements CustomQueueInterface<E> {
    private final CustomArrayList<E> ref;
    private int size;

    public CustomMinHeapPriorityQueue() {
        this.ref = new CustomArrayList<>();
        this.size = 0;
    }

    private void swap(int idx1, int idx2) {
        E temp = ref.get(idx1);
        ref.set(idx1, ref.get(idx2));
        ref.set(idx2, temp);
    }

    private int leftChildIdx(int idx) {
        return 2 * idx + 1;
    }

    private int rightChildIdx(int idx) {
        return 2 * idx + 2;
    }

    private void handleInsertion() {
        int currIdx = size - 1;
        int parentIdx = (currIdx - 1) / 2;

        while(ref.get(currIdx).compareTo(ref.get(parentIdx)) < 0 && currIdx > 0) {
            swap(currIdx, parentIdx);
            currIdx = parentIdx;
            parentIdx = (currIdx - 1) / 2;
        }
    }

    private void handleDeletion(int idx) {
        int leftIdx = leftChildIdx(idx);
        int rightIdx = rightChildIdx(idx);

        int minIdx = idx;
        if(leftIdx < size && ref.get(leftIdx).compareTo(ref.get(idx)) < 0) {
            minIdx = leftIdx;
        }

        if(rightIdx < size && ref.get(rightIdx).compareTo(ref.get(minIdx)) < 0) {
            minIdx = rightIdx;
        }

        if(minIdx != idx) {
            swap(minIdx, idx);
            handleDeletion(minIdx);
        }
    }

    /*
    * Checks if the Priority Queue is empty or not
    * if it does, Returns true, Otherwise false
    * */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
    * Adds element in to the Priority Queue
    * With O(log n) TC
    * */
    public void add(E element) {
        ref.add(element);
        this.size++;
        handleInsertion();
    }

    /*
    * Returns min element i.e., first element from the Priority Queue
    * With O(1) TC
    * */
    public E peek() {
        if(isEmpty()) {
            return null;
        }

        return ref.get(0);
    }

    /*
     * Remove and returns min element i.e., first element from the Priority Queue
     * With O(log n) TC
     * */
    public E poll() {
        if(isEmpty()) {
            return null;
        }

        if(size == 1) {
            return ref.remove(--size);
        }

        E element = ref.get(0);
        ref.set(0, ref.get(size - 1));
        ref.remove(--size);
        handleDeletion(0);


        return element;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");

        int count = 0;
        for(int i = 0; i < size; i++) {
            res.append(ref.get(i));
            if(++count < size) {
                res.append(", ");
            }
        }

        res.append("]");
        return res.toString();
    }
}
