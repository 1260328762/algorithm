package com.cl.algorithm.queue;

/**
 * @author chenliang
 * @date 2020-05-19
 */
public class LinkedQueue<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T pop(){
        if (size == 0) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T peek(){
        return head.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printAll(){
        while (!isEmpty()) {
            System.out.print(pop() + "->");
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
