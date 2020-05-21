package com.cl.algorithm.linkedlist;

/**
 * @author chenliang
 * @date 2020-05-21
 */
public class Node<T> {

    public T data;

    public Node<T> next;


    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void printAll(){
        Node<T> curNode = this;
        while (curNode != null) {
            System.out.print(curNode.data + "->");
            curNode = curNode.next;
        }
    }
}
