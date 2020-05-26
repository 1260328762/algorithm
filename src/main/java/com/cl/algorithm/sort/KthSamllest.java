package com.cl.algorithm.sort;

/**
 * @author chenliang
 * @date 2020-05-25
 * 查找一个无序数组中第K大的元素
 */
public class KthSamllest {

    public static int find(int[] arr, int k) {
        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }
        return arr[partition];
    }


    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int i = start;
        for (int j = start; j < end; j++) {
            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
            if (arr[j] > pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, end);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
