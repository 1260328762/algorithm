package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/3/15 22:11
 * 543. 二叉树的直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2  3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiameterOfBinaryTree {

    int result = 0;

    /**
     * 解题思路，将此题转换为求树的最大深度，在求左右子树最大深度时，计算左子树和右子树之间最大直径。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return result;
    }

    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        int diameter = leftHeight + rightHeight;
        if (diameter > result) {
            result = diameter;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
