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
            head = new Node<>(data);
            size++;
        } else {
            addTail(data);
        }
    }

    public void addTail(T data) {
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(data);
    }

    public void printAll() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
    }

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
