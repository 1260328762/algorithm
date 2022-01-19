package com.cl.question.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/19 21:06
 * 打印N叉树
 */
public class PrintNtree {

    /**
     * 先序遍历n叉树
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderRe(root, result);
        return result;
    }

    public void preOrderRe(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for(Node node : root.children) {
            preOrderRe(node, result);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
