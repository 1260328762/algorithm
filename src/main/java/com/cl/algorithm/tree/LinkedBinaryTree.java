package com.cl.algorithm.tree;

/**
 * @author chenliang
 * @date 2020-06-08
 * 链表结构的二叉树
 */
public class LinkedBinaryTree {

    private Node<Integer> root;

    public void add(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            if (root.data >= data) {
                appendLeft(root, data);
            } else {
                appendRight(root, data);
            }
        }
    }

    public void remove(int data) {
        Node<Integer> cur = root;
        Node<Integer> pNode = null;
        while (cur != null && cur.data != data) {
            pNode = cur;
            if (cur.data > data)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if (cur == null) return;

        // 要删除的节点为头节点
        if (pNode == null) {
            if (cur.right != null) {
                cur = cur.right;
                while (cur.left != null) {
                    pNode = cur;
                    cur = cur.left;
                }
                cur.left = root.left;
                if (pNode != null) {
                    pNode.left = cur.right;
                }
                root = cur;
            } else if (cur.left != null) {
                cur = cur.left;
                while (cur.right != null) {
                    pNode = cur;
                    cur = cur.right;
                }
                if (pNode != null) {
                    cur.left = root.left;
                    pNode.right = cur.left;
                }
                root = cur;
            } else {
                root = null;
            }
        } else if (cur.left == null || cur.right == null) {
            // 只有一个叶子节点的情况
            if (cur.left == null) {
                if (pNode.left == cur)
                    pNode.left = cur.right;
                else
                    pNode.right = cur.right;
            } else {
                if (pNode.left == cur)
                    pNode.left = cur.left;
                else
                    pNode.right = cur.left;
            }
        } else {
            // 有两个子节点的情况
            Node<Integer> minNode = cur.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            if (pNode.left == cur) {
                pNode.left = minNode;
                minNode.left = cur.left;
            } else {
                pNode.right = minNode;
                minNode.right = cur.right;
            }
        }
    }


    /**
     * 求数的高度
     * @return
     */
    public int height(){
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

    private int deep(Node<Integer> root) {
        if (root == null) return 0;
        int leftDeep = 1 + deep(root.left);
        int right = 1 + deep(root.right);
        return Math.max(leftDeep, right);
    }



    /**
     * 先序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<Integer> root) {
        if (root == null) return;
        // 打印中点和左子树
        System.out.print(root.data + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历(有序)
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<Integer> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " -> ");
        inOrder(root.right);
    }

    /**
     * 按层遍历
     */
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node<Integer> root) {
        if (root == null) return;

        levelOrder(root.left);
        levelOrder(root.right);

        Node<Integer> left = root.left;
        if (left != null) {
            System.out.print(left.data + "-");
        }

        Node<Integer> right = root.right;
        if (right != null) {
            System.out.print(right.data + "-");
        }
    }

    /**
     * 后续遍历
     */
    public void afterOrder() {
        afterOrder(root);
    }

    private void afterOrder(Node<Integer> root) {
        if (root == null) return;
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.data + " -> ");
    }

    private void appendRight(Node<Integer> node, Integer data) {
        if (node.right == null) {
            node.right = new Node<>(data);
        } else {
            if (node.data >= data) {
                appendLeft(node, data);
            } else {
                appendRight(node.right, data);
            }
        }
    }

    private void appendLeft(Node<Integer> node, Integer data) {
        if (node.left == null) {
            node.left = new Node<>(data);
        } else {
            if (node.data >= data) {
                appendLeft(node.left, data);
            } else {
                appendRight(node, data);
            }
        }
    }

    private static class Node<T> {

        public Node(T data) {
            this.data = data;
        }

        private T data;
        private Node<T> left;
        private Node<T> right;
    }
}
