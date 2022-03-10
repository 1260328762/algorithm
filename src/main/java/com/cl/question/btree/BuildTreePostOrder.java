package com.cl.question.btree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenliang
 * @since 2022/3/6 10:27
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树
 * <p>
 * 示例 1:
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTreePostOrder {

    Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 思路
     * 对于一棵树的中序遍历，其遍历形式总是[[左子树]，根节点，[右子树]]
     * 对于一棵树后续遍历，其遍历形式总是[[左子树]，[右子树]，跟]
     * 找出跟节点在中序遍历的位置即可确定，其左右子树的范围
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = indexMap.get(root.val);
        int rightCount = inEnd - rootIndex;

        TreeNode right = build(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightCount, postEnd - 1);
        TreeNode left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postEnd - rightCount - 1);
        root.right = right;
        root.left = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTreePostOrder().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
