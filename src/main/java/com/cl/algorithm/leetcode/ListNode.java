package com.cl.algorithm.leetcode;

/**
 * @author chenliang
 * @date 2020-07-13
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int first, int[] nums) {
        this.val = first;
        addAll(nums);
    }

    public void addAll(int[] nums) {
        ListNode tail = this;
        while (tail.next != null) {
            tail = tail.next;
        }

        for (int num : nums) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }
    }

    public void printAll(){
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " > ");
            cur = cur.next;
        }
    }
}
