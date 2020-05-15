package com.cl.algorithm.u6;

/**
 * @author chenliang
 * @date 2020-05-14
 */
public class SingleLinkedList<T> {

    private Node<T> head;

    private int size;

    public SingleLinkedList() {
        this.size = 0;
    }

    public void add(T data) {
        if (head == null) {
            addHead(data);
        } else {
            addTail(data);
        }
    }

    public void addRing(T data) {
        Node<T> tail = findTail();
        tail.next = new Node<>(data, head);
    }

    private void addHead(T data) {
        head = new Node<>(data);
        size++;
    }

    private Node<T> findTail() {
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private void addTail(T data) {
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(data);
        size++;
    }

    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
    }

    /**
     * 链表反转
     */
    public void reverse() {
        if (head != null) {
            Node<T> curNode = head;
            Node<T> preNode = null;
            while (curNode != null) {
                Node<T> nextTemp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextTemp;
            }
            head = preNode;
        }
    }

    /**
     * 递归反转链表空间复杂度O(n) 因为递归会占用栈空间
     * TODO 递归反转链表：待研究
     */
    public void recursionReverse() {
        head = doReverse(head);
    }

    private Node<T> doReverse(Node<T> head) {
        if (head == null || head.next == null) return head;
        Node<T> p = doReverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    /**
     * 检测链表是否有环
     * @return
     */
    public boolean hasCycle() {
        Node<T> curNode = head;
        if (curNode == null || curNode.next == null) return false;

        Node<T> slowPointer = curNode;
        Node<T> fastPointer = curNode;

        Node<T> slowGuide = curNode;
        Node<T> fastGuide = curNode;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowGuide.next;
            fastPointer = fastGuide.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }

            slowGuide = slowPointer;
            fastGuide = fastPointer;
        }
        return false;
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

}
