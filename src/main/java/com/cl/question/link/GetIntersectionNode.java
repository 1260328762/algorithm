package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/12 18:05
 * <p>
 * 160. 相交链表
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解法(1.暴力解法(时间复杂度O(m  * n)), 2.hash表 3.双指针(TODO 未搞懂),
 * 4, TODO 分别计算两个链表的长度，如果b比a长n个，则让b先往前走n步，然后a和b同步往前走进行比较)
 */
public class GetIntersectionNode {

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
}
