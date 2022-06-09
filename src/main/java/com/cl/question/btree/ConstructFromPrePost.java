package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/3/9 22:15
 * <p>
 * 给定两个整数数组，preorder和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructFromPrePost {

    /**
     * 根据二叉树的后序遍历结果无法在先序结果中确定根节点后面的节点是左节点还是右节点，所以只能假设跟节点后面的节点都是左节点，以此来重构二叉树
     * 假设现有两个二叉树如下
     *     1              1
     *      \            /
     *       3          3
     *      / \        / \
     *     6   7      6   7
     * 上面两颗二叉树的先序和后续遍历都一致，preorder=[1,3,6,7] postorder=[6,7,3,1]
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root;

        int nextRootIndex = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                nextRootIndex = i;
                break;
            }
        }
        int leftCount = nextRootIndex - postStart + 1;

        TreeNode left = build(preorder, preStart + 1, preStart + leftCount, postorder, postStart, nextRootIndex);
        TreeNode right = build(preorder, preStart + leftCount + 1, preEnd, postorder, nextRootIndex + 1, postEnd);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new ConstructFromPrePost().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode);
    }
}
