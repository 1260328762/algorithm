package com.cl.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author chenliang
 * @date 2020-05-20
 */
public class App {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            nums[i] = random.nextInt(100000);
        }



        long l = System.currentTimeMillis();

        System.out.println(System.currentTimeMillis() - l);

    }
}
