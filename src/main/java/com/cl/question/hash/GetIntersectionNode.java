package com.cl.question.hash;

import com.cl.question.link.ListNode;

import java.util.HashSet;

/**
 * @author chenliang
 * @since 2022/1/6 16:17
 * 相交链表
 * 其他解法 {@link com.cl.question.link.GetIntersectionNode}
 */
public class GetIntersectionNode {

    /**
     * hash表解法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode curA = headA;
        while (curA != null) {
            hashSet.add(curA);
            curA = curA.next;
        }

        ListNode curB = headB;
        while (curB != null) {
            if (hashSet.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }

        return null;
    }
}
