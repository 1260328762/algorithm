package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/3/1 21:44
 * <p>
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlattenToLinkList {

    TreeNode tail;

    public void flatten(TreeNode root) {
        preOrder(root);
    }

    /**
     * 按照先序遍历方式，依次将节点连接到tail的right节点，同时保存root.right节点，以供后续遍历右子树使用
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        if (tail == null) {
            tail = root;
        } else {
            tail.right = root;
            tail = tail.right;
        }

        preOrder(root.left);
        preOrder(temp);
        root.left = null;
    }
}
