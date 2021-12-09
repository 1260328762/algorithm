package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/8 21:15
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    /**
     * 本题核心思想在于进位从左往右进，普通加法正好相反，也不能转换位整数进行相加，因为会有溢出风险，即使是long类型
     */
    public ListNode addTowNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int redun = 0;
        while (tmp1 != null || tmp2 != null) {
            int i1 = tmp1 == null ? 0 : tmp1.val;
            int i2 = tmp2 == null ? 0 : tmp2.val;
            int result = i1 + i2 + redun;
            redun = result / 10;

            ListNode newNode = new ListNode(result % 10);
            tail.next = newNode;
            tail = newNode;

            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }

        if (redun == 1) {
            tail.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers()
                .addTowNumbers(new ListNode(1, new ListNode(8)),
                        new ListNode(0));

        listNode.print();
    }
}
