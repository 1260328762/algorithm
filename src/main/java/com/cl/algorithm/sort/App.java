package com.cl.algorithm.sort;

import com.cl.algorithm.util.SortUtil;

import java.util.*;

/**
 * @author chenliang
 * @date 2020-05-20
 */
public class App {

    public static void main(String[] args) throws Exception {
        // int size = 10000000;
        // int[] arr = new int[]{182112288, 135278288, 135278688};


        // Random random = new Random();
        // arr = new int[size];
        // for (int i = 0; i < size; i++) {
        //     arr[i] = random.nextInt(900);
        // }

        // long l = System.currentTimeMillis();
        // LinearSort.radixSort(arr);
        // System.out.println(System.currentTimeMillis() - l);
        //
        // System.out.println(Arrays.toString(arr));

        int[] arr = new int[]{1, 2, 3, 4, 6, 5};
        Sort.mergeSort(arr);

    }

}
