package com.cl.question.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/19 21:08
 * <p>
 * 102. 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * <p>
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class levelOrderGroup {

    /**
     * 解题思路：首先根节点放入队列中，循环出队，然后将出队的元素左右节点分别放入队列尾部。当队列不为空时，队列中所在元素一定属于同一个层级，
     * 例，现有二叉树如下 3
     *               /  \
     *              9   20
     *                 /  \
     *                15  7
     * 1，首先将头节点3放入队列中
     * 2，此时队列中元素属于同一层级,将同一层级元素循环取出，放入结果集，同时，获取该元素左右节点分别放入队列中
     * 3，开始下一次循环，此时队列不为空，并且队列中所有元素处于同一层级，分别时9和20，后面只需要循环第2步即可，一直到队列为空
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }

        return result;
    }
}
