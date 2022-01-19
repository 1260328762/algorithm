package com.cl.question.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/19 21:02
 * 二叉树的前，中，后序遍历
 */
public class PrintTree {

    /**
     * 先序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inOrder(root, results);
        return results;
    }

    public void inOrder(TreeNode root, List<Integer> results) {
        if (root == null) return;
        inOrder(root.left, results);
        results.add(root.val);
        inOrder(root.right, results);
    }

    /**
     * 后续遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postOrder(root, results);
        return results;
    }

    public void postOrder(TreeNode root, List<Integer> results) {
        if (root == null) return;
        postOrder(root.left, results);
        postOrder(root.right, results);
        results.add(root.val);
    }
}
