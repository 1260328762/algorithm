package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/26 13:44
 * <p>
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {

    /**
     * 广度优先
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();

            if (f == null && s == null) {
                continue;
            }
            if (f == null || s == null) {
                return false;
            }

            if (f.val != s.val) return false;

            queue.add(f.left);
            queue.add(s.right);
            queue.add(f.right);
            queue.add(s.left);
        }

        return true;
    }

    /**
     * 深度优先
     */
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode f, TreeNode s) {
        if (f == null && s == null) return true;
        if (f == null || s == null) return false;

        return f.val == s.val && check(f.left, s.right) && check(f.right, s.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{1, 2, 2, null, 3, null, 3});
        boolean symmetric = new IsSymmetric().isSymmetric(root);
        System.out.println(symmetric);
    }
}
