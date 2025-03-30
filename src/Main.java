import CustomUtil.ArrayList.CustomArrayList;
import CustomUtil.HashMap.CustomHashMap;
import CustomUtil.HashSet.CustomHashSet;
import CustomUtil.LinkedList.CustomLinkedList;
import CustomUtil.PriorityQueue.MaxHeap.CustomMaxHeapPriorityQueue;
import CustomUtil.PriorityQueue.MinHeap.CustomMinHeapPriorityQueue;
import CustomUtil.Queue.CustomQueue;
import CustomUtil.Stack.CustomStack;
import CustomUtil.StringBuilder.CustomStringBuilder;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        CustomHashMap<Integer, Integer> map = new CustomHashMap<>();
        CustomHashSet<Integer> set = new CustomHashSet<>();
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        CustomMaxHeapPriorityQueue<Integer> maxima = new CustomMaxHeapPriorityQueue<>();
        CustomMinHeapPriorityQueue<Integer> minima = new CustomMinHeapPriorityQueue<>();
        CustomQueue<Integer> queue = new CustomQueue<>();
        CustomStack<Integer> stack = new CustomStack<>();
        CustomStringBuilder sb = new CustomStringBuilder();

        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(ll);
        System.out.println(maxima);
        System.out.println(minima);
        System.out.println(queue);
        System.out.println(stack);
        System.out.println(sb);
    }
}