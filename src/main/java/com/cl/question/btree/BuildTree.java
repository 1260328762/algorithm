package com.cl.question.btree;


/**
 * @author chenliang
 * @since 2022/3/5 18:44
 * <p>
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    /**
     * 思路
     * 对于一棵树的先序遍历，其遍历形式总是[根节点，[左子树]，[右子树]]
     * 对于一棵树的中序遍历，其遍历形式总是[[左子树]，根节点，[右子树]]
     * 找出跟节点在中序遍历的位置即可确定，其左右子树的范围
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        // 查找root节点在inOrder中的位置，那么root左右子树范围分别为[inStart, rootIndex-1],[rootIndex + 1, inEnd]
        // 这一步可以构建一个hash表提升效率
        int rootIndex = inStart;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        int leftCount = rootIndex - inStart;
        // 构建左子树
        TreeNode left = build(preorder, preStart + 1, preStart + leftCount, inorder, inStart, rootIndex - 1);
        TreeNode right = build(preorder, preStart + leftCount + 1, preEnd, inorder, rootIndex + 1, inEnd);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new BuildTree().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(root);
    }
}
