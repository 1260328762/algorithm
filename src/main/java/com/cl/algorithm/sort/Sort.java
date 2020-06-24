package com.cl.algorithm.sort;

import com.cl.algorithm.linkedlist.Node;

/**
 * @author chenliang
 * @date 2020-05-20
 */
public class Sort {


    /**
     * 冒泡排序
     * 时间复杂度：O(n²)
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                int num = nums[j];
                if (num > nums[j + 1]) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = num;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    /**
     * 链表版的冒泡排序
     * TODO 链表版冒泡排序
     *
     * @param head
     */
    public void bubbleSort(Node<Integer> head) {
        Node<Integer> curNode = head;

        Node<Integer> newNode = new Node<>();
        while (curNode.next != null) {
            Integer curData = curNode.data;
            Node<Integer> nextNode = curNode.next;
            if (curData > nextNode.data) {
                curNode.next = nextNode.next;
                nextNode.next = curNode;
            }
            curNode = nextNode;
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(n²)
     *
     * @param nums
     */
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                int num = nums[j];
                if (num > value) {
                    nums[j + 1] = num;
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(n²)
     *
     * @param nums
     */
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            int j = i + 1;
            for (; j < nums.length; j++) {
                int value = nums[j];
                if (nums[minIndex] >= value) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    /**
     * 数组逆序度
     */
    private static int num = 0;

    /**
     * 归并排序
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        doMergeSort(nums, 0, nums.length - 1);
        System.out.println(num);
    }

    private static void doMergeSort(int[] a, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        doMergeSort(a, start, mid);
        doMergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (a[i] > a[j]) {
                temp[index++] = a[j++];
                num += (mid - i + 1);
            } else {
                temp[index++] = a[i++];
            }
        }

        // 将数组剩余部分直接添加到临时数组后面
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= end) {
            temp[index++] = a[j++];
        }

        index = 0;
        while (start <= end) {
            a[start++] = temp[index++];
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private static void doQuickSort(int[] a, int start, int end) {
        if (start >= end) return;

        int mid = partition(a, start, end);
        doQuickSort(a, start, mid - 1);
        doQuickSort(a, mid + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        int i = start;
        int pivot = a[end];
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                int temp = a[j];
                a[j] = a[i];
                a[i++] = temp;
            }
        }
        a[end] = a[i];
        a[i] = pivot;
        return i;
    }

}
