package com.cl.algorithm.u6;

import java.util.Scanner;

/**
 * @author chenliang
 * @date 2020-05-14
 * 基于链表实现的LRU算法
 */
public class LRUBaseLinkedList<T> {

    private Node<T> head;

    private final static Integer DEFAULT_CAPACITY = 10;

    private Integer size;

    private Integer capacity;

    public LRUBaseLinkedList(){
        head = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }


    public void add(T data){
        if (this.size == 0) {
            head = new Node<>(data);
            this.size++;
        } else {
            Node<T> node = findNode(data);
            // 链表中不存在此元素
            if (node == null) {
                // 链表已满
                if (this.size.equals(this.capacity)) {
                    removeTail();
                }
            } else {
                // 链表存在此元素，将此元素转移到头节点
                remove(data);
            }
            addHead(data);
        }
    }

    private void remove(T data) {
        if (data.equals(head.data)) {
            head = head.next;
            this.size--;
            return;
        }

        Node<T> preNode = findPreNode(data);
        // 查找到此数据的前节点
        if (preNode != null) {
            preNode.next = preNode.next.next;
            this.size--;
        }
    }

    private Node<T> findPreNode(T data){
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (data.equals(currentNode.next.data)) {
                return currentNode;
            }
            currentNode  = currentNode.next;
        }
        return null;
    }

    public void printAll(){
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + ",");
            currentNode = currentNode.next;
        }
    }

    private void addHead(T data) {
        this.head = new Node<>(data, head);
        this.size++;
    }

    private void removeTail(){
        if (this.size == 1) {
            this.head = new Node<>();
            this.size--;
        }

        Node<T> currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        this.size--;
    }

    private Node<T> findNode(T data) {
        Node<T> currentNode = head;
        if(data.equals(currentNode.data))
            return currentNode;

        while (currentNode.next != null) {
            if (data.equals(currentNode.data)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }



    private class Node<T>{
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

class Application{
    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
            System.out.println();
        }
    }
}