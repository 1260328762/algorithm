package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/7 15:21
 * <p>
 * 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElements {

    /**
     * 不新建节点
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        // 前一个节点
        ListNode pre = null;
        while (current != null) {
            if (current.val == val) {
                if (pre == null) {
                    head = head.next;
                    current = current.next;
                } else {
                    pre.next = current.next;
                    current = pre.next;
                }

            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟节点，但不用记录pre节点
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }


    /**
     * 使用虚拟节点
     */
    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy.next;
        // 前一个节点
        ListNode pre = dummy;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                current = pre.next;
            } else {
                pre = current;
                current = current.next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(7, new ListNode(7, new ListNode(7)));

        ListNode listNode = new RemoveElements().removeElements(head, 7);

        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
