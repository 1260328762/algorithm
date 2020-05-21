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
     * @param nums
     */
    public void insertionSort(int[] nums){
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
}
