package com.cl.algorithm.tree;

/**
 * @author chenliang
 * @date 2020-06-08
 * 基于数组实现的二叉树
 */
public class ArrayBinaryTree {

    private Integer[] items;

    public ArrayBinaryTree(int capacity) {
        items = new Integer[capacity];
    }

    public void add(int data){
        Integer root = items[1];
        if (root == null) {
            items[1] = data;
        } else {
            if (root >= data)
                appendLeft(1, data);
            else
                appendRight(1, data);
        }
    }

    private void appendLeft(int index, int data){
        int targetIndex = index * 2;
        Integer item = items[targetIndex];
        if (item == null) {
            items[targetIndex] = data;
        } else {
            if (item >= data) {
                appendLeft(targetIndex, data);
            } else {
                appendRight(targetIndex, data);
            }
        }
    }

    private void appendRight(int index, int data) {
        int targetIndex = index * 2 + 1;
        Integer item = items[targetIndex];
        if (item == null) {
            items[targetIndex] = data;
        } else {
            if (item >= data) {
                appendLeft(targetIndex, data);
            } else {
                appendRight(targetIndex, data);
            }
        }
    }

}
