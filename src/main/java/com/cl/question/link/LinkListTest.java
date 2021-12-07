package com.cl.question.link;

/**
 * @author chenliang
 * @since 2021/12/6 21:18
 */
public class LinkListTest {


    private static class Node {
        public int value;

        public Node next;
    }


    public static void main(String[] args) {
        Node head = new Node();
        head.value = 10;

        Node node = new Node();
        node.value = 11;
        head.next = node;


        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }
}
