package com.cl.algorithm.heap;

import java.util.Arrays;

/**
 * @author chenliang
 * @date 2020-06-11
 */
public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{0, 1, 2, 5, 3, 9, 4, 50, 40, 30, 8};

        int[] result = HeapSort.topK(arr, 4);

        System.out.println(Arrays.toString(result));
    }
}
