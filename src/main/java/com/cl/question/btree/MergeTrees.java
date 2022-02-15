package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/25 14:58
 * <p>
 * 617. 合并二叉树
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意:合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTrees {

    /**
     * 广度优先
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        root1.val = root2.val + root1.val;
        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.left != null) {
                if (node2.left != null) {
                    node1.left.val = node1.left.val + node2.left.val;
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                }
            } else {
                if (node2.left != null) {
                    node1.left = node2.left;
                }
            }

            if (node1.right != null) {
                if (node2.right != null) {
                    node1.right.val = node1.right.val + node2.right.val;
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                }
            } else {
                if (node2.right != null) {
                    node1.right = node2.right;
                }
            }
        }

        return root1;
    }

    /**
     * 深度优先
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees2(root1.left, root2.left);
        newNode.right = mergeTrees2(root1.right, root2.right);
        return newNode;
    }

    public static void main(String[] args) {
        TreeNode node1 = TreeNode.of(new Integer[]{1, 3, 2, 5});
        TreeNode node2 = TreeNode.of(new Integer[]{2, 1, 3, null, 4, null, 7});
        new MergeTrees().mergeTrees(node1, node2);
    }
}
