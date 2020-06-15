package com.cl.algorithm.heap;

/**
 * @author chenliang
 * @date 2020-06-15
 * 堆排序
 */
public class HeapSort {

    public static void sort(int[] arr) {
        heapify(arr);
        int maxIndex = arr.length - 1;
        while (maxIndex > 0) {
            swap(arr, 0, maxIndex);
            heapify(arr, --maxIndex);
        }
    }

    /**
     * 原地堆化，从前往后堆化
     */
    private static void heapify(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            while (index != 0 && arr[index] > arr[(index + 1) / 2 - 1]) {
                swap(arr, index, index = ((index + 1) / 2 - 1));
            };
        }
    }

    private static void heapify(int[] arr, int endIndex) {
        int i = 0;
        while (true) {
            int maxIndex = i;
            boolean find = false;
            if (i * 2 + 1 <= endIndex && arr[i] < arr[i * 2 + 1]){
                maxIndex = i * 2 + 1;
                find = true;
            } else if (i * 2 + 2 <= endIndex && arr[i] < arr[i * 2 + 2]) {
                maxIndex = i * 2 + 2;
                find = true;
            }
            if (find) {
                if (arr[i * 2 + 1] > arr[i * 2 + 2])
                    maxIndex = i * 2 + 1;
                else
                    maxIndex = i * 2 + 2;
            }

            if (i == maxIndex) break;
            swap(arr, i, maxIndex);
            i = maxIndex;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
