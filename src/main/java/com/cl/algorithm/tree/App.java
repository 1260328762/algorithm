package com.cl.algorithm.tree;

/**
 * @author chenliang
 * @date 2020-06-08
 */
public class App {
    public static void main(String[] args) {
        LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();
        linkedBinaryTree.add(8);
        linkedBinaryTree.add(5);
        linkedBinaryTree.add(10);
        linkedBinaryTree.add(3);
        linkedBinaryTree.add(20);
        linkedBinaryTree.add(19);
        linkedBinaryTree.add(18);
        linkedBinaryTree.add(17);
        linkedBinaryTree.add(16);
        linkedBinaryTree.add(50);
        linkedBinaryTree.add(2);
        linkedBinaryTree.add(4);
        linkedBinaryTree.add(-1);
        linkedBinaryTree.add(60);
        linkedBinaryTree.add(70);
        // linkedBinaryTree.remove(3);
        // linkedBinaryTree.remove(8);
        // linkedBinaryTree.remove(10);
        // linkedBinaryTree.remove(20);
        // linkedBinaryTree.remove(50);

        System.out.println(linkedBinaryTree.height());
    }
}
