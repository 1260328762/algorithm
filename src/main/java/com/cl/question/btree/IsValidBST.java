package com.cl.question.btree;

import java.util.Stack;

/**
 * @author chenliang
 * @since 2022/2/10 14:24
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {

    Integer minValue = null;
    boolean result = true;

    /**
     * 中序遍历,中序遍历产生的结果具有有序性
     */
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if (!result || root == null) return;
        inOrder(root.left);
        if (minValue == null) {
            minValue = root.val;
        } else if (minValue > root.val) {
            result = false;
        } else {
            minValue = root.val;
        }
        inOrder(root.right);
    }

    /**
     * 使用while循环方式进行中序遍历
     */
    public boolean isValidBSTLoop(TreeNode root) {
        long minValue = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (node.val <= minValue) {
                return false;
            }

            minValue = node.val;
            root = node.right;
        }

        return true;
    }

    /**
     * 解题思路：如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
     * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树
     * 依据这个特性，递归判断每个节点的值是否在合理范围内
     * @param root
     * @return
     */
    public boolean isValidBSTRange(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val < low || root.val > high) return false;
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{5, 1, 4, null, null, 3, 6});
        boolean validBST = new IsValidBST().isValidBSTRange(root);
        System.out.println(validBST);
    }
}
