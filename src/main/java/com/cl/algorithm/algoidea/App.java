package com.cl.algorithm.algoidea;

/**
 * @author chenliang
 * @date 2020-06-24
 */
public class App {
    public static void main(String[] args) {
        // Backtracking.queensEight();

        int[] arr = new int[]{2, 2, 4, 6};

        System.out.println(Backtracking.knapsack(arr, arr.length, 10));

        // Backtracking.loadPack(10, arr);

    }
}
