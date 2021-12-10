package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/10 10:14
 * <p>
 * 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    /**
     * 空间复杂0n
     */
    public boolean isPalindrome(ListNode head) {
        ListNode reversed = null;

        ListNode current = head;
        while (current != null) {
            // ListNode newNode = new ListNode(current.val, reversed);
            reversed = new ListNode(current.val, reversed);
            current = current.next;
        }

        current = head;
        while (reversed != null) {
            if (reversed.val != current.val) {
                return false;
            }
            reversed = reversed.next;
            current = current.next;
        }

        return true;
    }

    /**
     * 空间复杂度O1，在原链表上反转
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 查找链表中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转链表后版本部分
        ListNode reversed = reverse(slow);

        boolean result = true;
        // 比对是否回文
        ListNode current = head;
        ListNode reverseCurrent = reversed;
        while (reverseCurrent != null && reverseCurrent.next != null) {
            if (current.val != reverseCurrent.val) {
                result = false;
            }
            current = current.next;
            reverseCurrent = reverseCurrent.next;
        }

        // 将链表还原
        reverse(reversed);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode reversed = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = reversed;
            reversed = current;
            current = temp;
        }
        return reversed;
    }

    public static void main(String[] args) {
        boolean palindrome = new IsPalindrome().isPalindrome2(new ListNode(1, new ListNode(2,
                new ListNode(2, new ListNode(1, new ListNode(3))))));
        System.out.println(palindrome);
    }
}
