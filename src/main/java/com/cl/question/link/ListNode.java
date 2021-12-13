package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/7 17:20
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

    public void print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static ListNode of(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int i : arr) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        return dummy.next;
    }
}
