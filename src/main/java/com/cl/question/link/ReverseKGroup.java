package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/13 14:35
 * <p>
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {

    /**
     * 暴力破解
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        current = head;
        ListNode[] nodeArr = new ListNode[size];
        for (int i = 0; i < size; i++) {
            ListNode temp = current.next;
            current.next = null;
            nodeArr[i] = current;
            current = temp;
        }

        int startIndex = 0;
        int endIndex = startIndex + k - 1;
        while (startIndex < size && endIndex < size) {
            int middle = startIndex + (k / 2);
            int end = endIndex;
            for (int i = startIndex; i < middle; i++) {
                ListNode temp = nodeArr[i];
                nodeArr[i] = nodeArr[end];
                nodeArr[end] = temp;
                end--;
            }

            startIndex = startIndex + k;
            endIndex = startIndex + k - 1;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (ListNode listNode : nodeArr) {
            tail.next = listNode;
            tail = tail.next;
        }

        return dummy.next;
    }

    /**
     * 解题思想，将链表按照k个一组进行分组，先进行组内反转，完成之后再将各个部分连接起来
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode current = head;
        while (current != null) {
            ListNode start = current;
            ListNode end = current;
            int i = 1;
            for (; i < k && current != null; i++) {
                end = end.next;
                current = current.next;
            }

            if (current != null) {
                current = current.next;
            }

            // 当i < k 说明后续节点已经不够k个，则不用反转
            if (i <= k - 1 || end == null) {
                tail.next = start;
            } else {
                // 拼接链表
                ListNode[] nodeArr = reverse(start, end);
                tail.next = nodeArr[0];
                tail = nodeArr[1];
            }
        }

        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode current = head;
        ListNode pre = null;
        while (current != tail) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        tail.next = pre;
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode input = ListNode.of(new int[]{1, 2, 3, 4, 5});
        ListNode result = new ReverseKGroup()
                .reverseKGroup2(input, 1);
        result.print();
    }
}
