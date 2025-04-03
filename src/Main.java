/*
 * MIT License
 *
 * Copyright (c) 2025 realrnvr
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


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