package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/8 17:43
 * <p>
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode();

        ListNode tail = merge;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tail.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tail.next = tmp2;
                tmp2 = tmp2.next;
            }

            tail = tail.next;
        }

        tail.next = tmp1 == null ? tmp2 : tmp1;
        return merge.next;
    }

}
