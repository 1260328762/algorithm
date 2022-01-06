package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/12 18:05
 * <p>
 * 160. 相交链表
 * <p>
 * 给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解法
 * 1.暴力解法(时间复杂度O(m  * n)),
 * 2.hash表{@link com.cl.question.hash.GetIntersectionNode}
 * 3.双指针(TODO 未搞懂),
 */
public class GetIntersectionNode {

    /**
     * 暴力解法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            while (curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
            }
            curB = headB;
            curA = curA.next;
        }

        return null;
    }

    /**
     * 双指针解法时间复杂度O(m + n)
     * 解题思路：如果A和B有相交，那么两个链表相交节点后面的节点个数一定相同。
     * 此时如果两链表节点个数不同，也只是相交节点前面的节点个数不同，只需要将长链表和短链表前半部分对齐，然后挨个判断即可
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int na = 0;
        ListNode curA = headA;
        while (curA != null) {
            na++;
            curA = curA.next;
        }

        int nb = 0;
        ListNode curB = headB;
        while (curB != null) {
            nb++;
            curB = curB.next;
        }

        int sub = nb - na;

        // 将两链表对其
        if (sub > 0) {
            // headB 比 headA 长，后移sub位
            while (sub > 0) {
                headB = headB.next;
                sub--;
            }
        } else {
            sub = -sub;
            while (sub > 0) {
                headA = headA.next;
                sub--;
            }
        }

        // 双指针比较
        curA = headA;
        curB = headB;
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }

            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

}
