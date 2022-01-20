package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/20 14:58
 * <p>
 * 513. 找树左下角的值
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBottomLeftValue {

    /**
     * 广度优先：队列解法
     * 使用一个变量保存每一层最左侧的值，直到最后一层，返回该变量
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            int size = queue.size();

            Integer result = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (result == null) result = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (queue.isEmpty()) {
                return result;
            }
        }
    }

}
