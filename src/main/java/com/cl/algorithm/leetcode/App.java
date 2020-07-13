package com.cl.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author chenliang
 * @date 2020-07-13
 */
public class App {
    public static void main(String[] args) {
        //
        // int[] nums1 = new int[]{3, 8, 9, 0, 0, 0};
        // int[] nums2 = new int[]{4, 5, 6};
        //
        // Array.merge(nums1, 3, nums2, 3);
        //
        // System.out.println(Arrays.toString(nums1));


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);


        LinkedList.mergeTwoLists(l1, l2).printAll();

    }
}
