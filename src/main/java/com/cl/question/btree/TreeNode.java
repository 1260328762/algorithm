package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/18 17:25
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode of(Integer[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftIndex = index * 2 + 1;
            if (leftIndex < arr.length) {
                if (arr[leftIndex] != null) {
                    node.left = new TreeNode(arr[leftIndex]);
                    queue.add(node.left);
                }
            }

            int rightIndex = index * 2 + 2;
            if (rightIndex < arr.length) {
                if (arr[rightIndex] != null) {
                    node.right = new TreeNode(arr[rightIndex]);
                    queue.add(node.right);
                }
            }

            index++;
        }

        return root;
    }
}
