package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/2/15 20:50
 * <p>
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/successor-lcci/
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderSuccessor {

    TreeNode successor = null;
    boolean meet = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        preOrder(root, p);
        return successor;
    }

    public void preOrder(TreeNode root, TreeNode p) {
        if (root == null) return;
        preOrder(root.left, p);
        if (successor != null) return;
        if (root == p) {
            meet = true;
        } else if (meet) {
            successor = root;
        }
        preOrder(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        TreeNode result = new InorderSuccessor().inorderSuccessor(root, root.left.left.left);
        System.out.println(result);
    }
}
