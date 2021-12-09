package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/9 16:39
 * <p>
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();

        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = dummy.next;
            dummy.next = current;

            current = temp;
        }
        return dummy.next;
    }
}
