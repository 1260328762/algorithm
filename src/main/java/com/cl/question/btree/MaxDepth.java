package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/20 21:19
 * <p>
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {

    int maxDepth = 0;

    /**
     * 深度优先；树的最大深度等于左子树和右子树的最大值加1，可以使用递归完成
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * 广度优先，使用队列，层层遍历，找到最大层
     */
    public int maxDepth2(TreeNode root) {
        int level = 0;
        if (root == null) return level;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }

        return level;
    }


}
