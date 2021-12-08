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
            System.out.println(current.val);
            current = current.next;
        }
    }
}
