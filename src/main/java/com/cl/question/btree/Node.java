package com.cl.question.btree;

import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/20 11:31
 */
public class Node {

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
}
