package com.cl.algorithm.linkedlist;

/**
 * @author chenliang
 * @date 2020-07-10
 */
public class LeetCodeTest {


    /**
     * 单链表的反转
     * @param root
     * @param <T>
     */
    public static <T> void reverse(Node<T> root){
        if (root != null) {
            Node<T> result = null;
            Node<T> curNode = root;

            while (curNode != null) {
                Node<T> next = curNode.next;
                curNode.next = result;
                result = curNode;
                curNode = next;
            }
            result.printAll();
        }
    }

    public static <T> Node<T> reverseRec(Node<T> curNode) {
        if (curNode.next == null) return curNode;
        Node<T> p = reverseRec(curNode.next);
        curNode.next.next = curNode;
        curNode.next = null;
        return p;
    }


    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.next = new Node<>(2);
        root.next.next = new Node<>(3);
        root.next.next.next = new Node<>(4);

        reverseRec(root).printAll();
    }

}
