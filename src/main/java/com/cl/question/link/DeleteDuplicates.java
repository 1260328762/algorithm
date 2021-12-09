package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/7 18:52
 * <p>
 * 83. 删除排序链表中的重复元素
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            // 如果出现重复元素，删除后面那个
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public ListNode delete2(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-111, null);//虚拟头节点
        ListNode tail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val != tail.val) {
                tail.next = p;
                tail = p;
                p.next = null;
            }
            p = tmp;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new DeleteDuplicates().delete2(new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(3))))));
        listNode.print();
    }

}
