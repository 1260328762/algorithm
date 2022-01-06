package com.cl.question.hash;

import com.cl.question.link.ListNode;

import java.util.HashSet;

/**
 * @author chenliang
 * @since 2022/1/6 20:53
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateNodes {

    /**
     * hash表解法
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode cur = head;
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while (cur != null) {
            if (!hashSet.contains(cur.val)) {
                tail.next = cur;
                tail = tail.next;
                hashSet.add(cur.val);
            }
            cur = cur.next;
        }
        tail.next = null;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new RemoveDuplicateNodes().removeDuplicateNodes(ListNode.of(new int[]{1, 2, 2}));
        listNode.print();
    }
}
