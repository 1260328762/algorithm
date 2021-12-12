package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/11 20:03
 * <p>
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 1.计算长度法，2.使用栈的方式(先全部入栈，然后出栈，第n个出栈的就是倒数第n个) 3.TODO 双指针
 */
public class RemoveNthFromEnd {

    /**
     * 计算长度法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        while (fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }

        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 需要删除头节点
        if (slow == head) {
            return head.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    /**
     * 双指针解法，先用一个虚拟节点指向head节点，first从head开始指针先走n个节点。然后second从dummy节点开始和first共同往后走，指到first指向空节点
     * 此时second节点正好在要删除节点的前一个节点
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        while (n > 0) {
            first = first.next;
            n--;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.of(new int[]{1, 2, 3, 4, 5});

        ListNode result = new RemoveNthFromEnd().removeNthFromEnd3(listNode, 4);
        result.print();
    }
}
