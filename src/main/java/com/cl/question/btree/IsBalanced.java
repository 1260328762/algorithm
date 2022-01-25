package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/1/21 15:52
 * <p>
 * 剑指 Offer 55 - II. 平衡二叉树
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalanced {

    private boolean balanced = true;

    /**
     * 深度优先，自顶向上，依次判断对应节点左右子树是否是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        if (!balanced) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        boolean balanced = new IsBalanced().isBalanced(root);
        System.out.println(balanced);
    }
}
