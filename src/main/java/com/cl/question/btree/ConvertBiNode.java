package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/3/2 21:08
 * <p>
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * <p>
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBiNode {

    TreeNode head;
    TreeNode tail;

    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head;
    }

    /**
     * 创建头尾节点，按照中序顺序把节点连接在尾节点的right指针即可
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (tail == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            tail = tail.right;
        }
        inOrder(root.right);
        root.left = null;
    }
}
