package com.cl.question.hash;

import com.cl.question.link.ListNode;

import java.util.HashSet;

/**
 * @author chenliang
 * @since 2022/1/6 17:35
 * 141. 环形链表
 * 双指针解法 {@link com.cl.question.link.HasCycle}
 */
public class HasCycle {

    /**
     * hash表解法
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return true;
            }

            hashSet.add(cur);
            cur = cur.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2, listNode);

        System.out.println(new HasCycle().hasCycle(listNode));
    }
}
