package com.cl.question.btree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthLargest {

    int kthValue = 0;
    int k = 0;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return kthValue;
    }

    /**
     * 按照右根左的顺序遍历二叉树，得到的数据是逆序的
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.right);
        if (k == 0) return;
        if (--k == 0) kthValue = root.val;
        inOrder(root.left);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{3, 1, 4, null, 2});
        int kthLargest = new KthLargest().kthLargest(root, 1);
        System.out.println(kthLargest);
    }
}
