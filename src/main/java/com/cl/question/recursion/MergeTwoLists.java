package com.cl.question.recursion;

import com.cl.question.link.ListNode;

/**
 * @author chenliang
 * @since 2021/12/24 20:30
 * <p>
 * 剑指 Offer 25. 合并两个排序的链表
 * <p>
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    /**
     * 标准递归写法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        compare(dummy, l1, l2);
        return dummy.next;
    }

    private void compare(ListNode dummy, ListNode l1, ListNode l2) {
        if (l1 == null) {
            dummy.next = l2;
        }
        if (l2 == null) {
            dummy.next = l1;
        }

        if (l1 == null || l2 == null) return;


        if (l1.val < l2.val) {
            dummy.next = l1;
            compare(dummy.next, l1.next, l2);
        } else {
            dummy.next = l2;
            compare(dummy.next, l1, l2.next);
        }
    }

    /**
     * 基于循环及创建新值的方式实现双链表合并
     */
    public ListNode mergeTowListLoopNewValue(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        // 循环判断大小，一直到其中一个列表循环完成
        while (l1 != null && l2 != null) {
            int newValue;
            if (l1.val > l2.val) {
                newValue = l2.val;
                l2 = l2.next;
            } else {
                newValue = l1.val;
                l1 = l1.next;
            }
            ListNode newNode = new ListNode(newValue);
            temp.next = newNode;
            temp = newNode;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return result.next;
    }

    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTowListLoopNewValue(ListNode.of(new int[]{1, 3, 4}), ListNode.of(new int[]{3, 4, 5}));

        listNode.print();
    }
}
