package com.cl.question.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/3/2 21:40
 * <p>
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeToDoublyList {

    Node head;
    Node tail;

    public Node treeToDoublyList(Node root) {
        if (root != null) {
            inOrder(root);
            head.left = tail;
            tail.right = head;
        }
        return head;
    }

    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        if (tail == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            root.left = tail;
            tail = tail.right;
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node node = Node.of(new Integer[]{4, 2, 5, 1, 3});
        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
        Node head = treeToDoublyList.treeToDoublyList(node);
        System.out.println(head);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public static Node of(Integer[] arr) {
            if (arr.length == 0) return null;
            Node root = new Node(arr[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int index = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int leftIndex = index * 2 + 1;
                if (leftIndex < arr.length) {
                    if (arr[leftIndex] != null) {
                        node.left = new Node(arr[leftIndex]);
                        queue.add(node.left);
                    }
                }

                int rightIndex = index * 2 + 2;
                if (rightIndex < arr.length) {
                    if (arr[rightIndex] != null) {
                        node.right = new Node(arr[rightIndex]);
                        queue.add(node.right);
                    }
                }

                index++;
            }

            return root;
        }
    }
}
