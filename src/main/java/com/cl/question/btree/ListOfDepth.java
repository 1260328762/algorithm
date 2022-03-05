package com.cl.question.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/3/5 17:28
 * <p>
 * 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListOfDepth {

    /**
     * 广度优先，按层遍历
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> nodeList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            ListNode tail = null;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (tail == null) {
                    tail = new ListNode(node.val);
                    nodeList.add(tail);
                } else {
                    tail.next = new ListNode(node.val);
                    tail = tail.next;
                }
            }
        }
        return nodeList.toArray(new ListNode[]{});
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
