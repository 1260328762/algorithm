package com.cl.question.btree;

import java.util.*;

/**
 * @author chenliang
 * @since 2022/3/23 21:41
 */
public class PathSum2 {

    HashSet<List<TreeNode>> hashSet = new HashSet<>();
    List<TreeNode> list = new ArrayList<>();

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return hashSet.size();
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) return;
        list.add(root);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        int round = list.size();
        for (int i = 0; i < round; i++) {
            int sum = 0;
            for (int j = i; j < list.size(); j++) {
                sum += list.get(j).val;
                if (sum == targetSum) {
                    hashSet.add(new ArrayList<>(list.subList(i, j + 1)));
                }
            }
        }
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        int i = new PathSum2().pathSum(TreeNode.of(new Integer[]{10,5,-3,3,2,null,11,0,0,null,1}), 8);
        System.out.println(i);
    }
}
