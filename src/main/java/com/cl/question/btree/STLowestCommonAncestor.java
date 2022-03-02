package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/2/24 21:09
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：此题可利用二叉搜索的特点，即左子树所有节点都比右子树节点小，如果root比p和q都小，则搜索root的右子树，反之搜索左子树，如果root在p和q之间，则root是lca
 */
public class STLowestCommonAncestor {

    TreeNode lca;

    /**
     * 递归解法
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    public void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (lca != null || root == null) return;
        int low = Math.min(p.val, q.val);
        int high = Math.max(p.val, q.val);
        if (root.val > low && root.val < high) {
            lca = root;
        }

        if ((root == p || root == q) && (root.val > low || root.val < high)) {
            lca = root;
        }

        if (root.val < low) {
            dfs(root.right, p, q);
        } else {
            dfs(root.left, p, q);
        }
    }

    public TreeNode lowestCommonAncestor_foreach(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        while (true) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
            lca = root;
        }

        return lca;
    }
}
