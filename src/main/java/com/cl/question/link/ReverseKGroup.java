package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/13 14:35
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
