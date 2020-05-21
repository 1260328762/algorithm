package com.cl.algorithm.sort;

import com.cl.algorithm.linkedlist.Node;

/**
 * @author chenliang
 * @date 2020-05-20
 */
public class App {
    public static void main(String[] args) {
        Sort sort = new Sort();
        Node<Integer> head = new Node<>(6);

        head.next = new Node<>(5);
        head.next.next = new Node<>(4);

        sort.bubbleSort(head);

        head.printAll();
    }
}
