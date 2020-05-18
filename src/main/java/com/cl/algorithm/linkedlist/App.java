package com.cl.algorithm.linkedlist;

/**
 * @author chenliang
 * @date 2020-05-14
 */
public class App {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // list.add(5);

        System.out.println(list.midData());

        list.printAll();

    }
}
