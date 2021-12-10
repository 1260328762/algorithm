package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/10 17:33
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode tail = head;
        ListNode even = head.next;
        ListNode evenTail = even;
        while (current != null && current.next != null) {
            tail.next = current.next.next;
            tail = tail.next;

            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
            current = current.next.next;
        }

        return even;
    }
}
