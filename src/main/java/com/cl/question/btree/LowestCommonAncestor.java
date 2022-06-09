package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/2/23 21:34
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * <p>
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

    TreeNode result;

    /**
     * 通过观察二叉树规律可得出以下结论
     * 1.如果节点node为p和q的最近公共祖先,那么p和q一定分布在node的左右子树中
     * 2.如果node等于p，那么q一定分布在node的左子树或右子树
     * 3.如果node等于q，那么p一定分布在node的左子树或右子树
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        if (result != null) return 0;
        int leftCount = dfs(root.left, p, q);
        int rightCount = dfs(root.right, p, q);

        // p和q分别在左右子树中，那么root一定为最近公共祖先
        if (leftCount == 1 && rightCount == 1) {
            result = root;
        }

        // 如果p或q任意一个等于root，并且另外一个节点分布在左子树或右子树中，那么root一定为最近公共祖先
        if ((leftCount == 1 || rightCount == 1) && (root == p || root == q)) {
            result = root;
        }

        if (root == q || root == p || leftCount == 1 || rightCount == 1) {
            return 1;
        }
        return 0;
    }
}
