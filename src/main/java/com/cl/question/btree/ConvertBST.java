package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/2/15 11:15
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 示例 2：
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        inOrder(root, 0);
        return root;
    }

    /**
     * 反序中序遍历累加节点值
     */
    public int inOrder(TreeNode root, int sum) {
        if (root == null) return sum;
        root.val = inOrder(root.right, sum) + root.val;
        return inOrder(root.left, root.val);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.of(new Integer[]{3, 2, 4, 1});
        TreeNode node = new ConvertBST().convertBST(root);
        System.out.println(node);
    }
}
