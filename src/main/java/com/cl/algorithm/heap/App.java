package com.cl.algorithm.heap;

import java.util.Arrays;

/**
 * @author chenliang
 * @date 2020-06-11
 */
public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1, 2, 5, 3, 9, 4, 50, 40};

        HeapSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
