package com.cl.algorithm.sort;

import java.util.Random;

/**
 * @author chenliang
 * @date 2020-05-26
 */
public class SortTest {

    public static long testMergeSort(int size){
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        long l = System.currentTimeMillis();
        Sort.mergeSort(arr);
        return System.currentTimeMillis() - l;
    }
}
