package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/10 17:33
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEvenList {

    /**
     * 分别组建奇数链表和偶数链表，完成之后偶数链表链接在奇数链表之后
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode tail = head;
        ListNode even = head.next;
        ListNode evenTail = even;
        while (evenTail != null && evenTail.next != null) {
            tail.next = tail.next.next;
            tail = tail.next;

            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
        }

        tail.next = even;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        ListNode listNode = new OddEvenList().oddEvenList(ListNode.of(arr));

        listNode.print();
    }
}
