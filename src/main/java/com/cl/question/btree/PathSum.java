package com.cl.question.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/3/16 21:34
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {

    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    /**
     * 使用回溯法穷举每一条路线
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        path(root, target, paths);
        return paths;
    }

    public void path(TreeNode root, int target, List<List<Integer>> paths) {
        if (root == null) return;
        temp.add(root.val);
        sum += root.val;
        if (target == sum && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(temp));
        }
        path(root.left, target, paths);
        path(root.right, target, paths);
        sum -= root.val;
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new PathSum()
                .pathSum(TreeNode.of(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(lists);
    }
}
