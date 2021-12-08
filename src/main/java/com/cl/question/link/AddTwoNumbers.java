package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/8 21:15
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long times = 10;
        long result = l1.val;
        ListNode current = l1.next;
        while (current != null) {
            result = result + ((long) current.val * times);
            times *= 10;
            current = current.next;
        }

        times = 10;
        long result2 = l2.val;
        current = l2.next;
        while (current != null) {
            result2 = result2 + ((long) current.val * times);
            times *= 10;
            current = current.next;
        }

        long value = result + result2;
        if (value == 0) {
            return new ListNode(0);
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (value != 0) {
            int m = (int) (value % 10);
            tail.next = new ListNode(m);
            tail = tail.next;
            value = value / 10;
        }

        return dummy.next;
    }


    // TODO 修改为计算器计算方式 反向计算
    public static void main(String[] args) {

        ListNode listNode = new AddTwoNumbers().addTwoNumbers(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))))))))),
                new ListNode(1, new ListNode(9, new ListNode(9,
                        new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                                new ListNode(9, new ListNode(9, new ListNode(9)))))))))));

        listNode.print();
    }
}
