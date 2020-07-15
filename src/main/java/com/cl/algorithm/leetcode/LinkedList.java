package com.cl.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenliang
 * @date 2020-07-13
 */
public class LinkedList {

    /**
     * 合并链表: 21
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode tail = head;
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;

        while(curNode1 != null && curNode2 != null){
            if(curNode1.val < curNode2.val){
                ListNode temp = curNode1.next;
                tail.next = curNode1;
                tail = tail.next;
                curNode1 = temp;
            } else {
                ListNode temp = curNode2.next;
                tail.next = curNode2;
                tail = tail.next;
                curNode2 = temp;
            }
        }

        if (curNode1 != null) {
            tail.next = curNode1;
        }

        if (curNode2 != null) {
            tail.next = curNode2;
        }

        return head.next;
    }


    /**
     * 合并K个有序链表：23
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tail = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length + 1,
                Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = tail.next;

            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return head.next;
    }

}
