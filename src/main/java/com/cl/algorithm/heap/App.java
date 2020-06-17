package com.cl.algorithm.heap;

/**
 * @author chenliang
 * @date 2020-06-11
 */
public class App {
    public static void main(String[] args) throws Exception {
        // HeapMid heap = new ArrayHeap(10, 0);

        HeapMid heap = new HeapMid();

        heap.add(1);
        heap.add(3);
        // heap.add(2);
        // heap.add(9);
        // heap.add(4);

        System.out.println(heap.mid());

        // while (heap.size() > 0) {
        //     System.out.println(heap.popHead());
        // }
    }
}
