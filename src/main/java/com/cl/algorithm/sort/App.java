package com.cl.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author chenliang
 * @date 2020-05-20
 */
public class App {


    public static void main(String[] args) {

        int size = 100000;


        Sort sort = new Sort();

        int[] a = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(size) + 1;
        }

        a[a.length - 1] = -2;

        int[] b = new int[]{5, 7, 10, 2, 1, 1, 10, 3, 4, -2};

        long l = System.currentTimeMillis();
        sort.mergeSort(a);

        System.out.println(System.currentTimeMillis() - l);

        System.out.println(Arrays.toString(a));
    }
}
