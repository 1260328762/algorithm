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

    public void printAll(){
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " > ");
            cur = cur.next;
        }
    }
}
