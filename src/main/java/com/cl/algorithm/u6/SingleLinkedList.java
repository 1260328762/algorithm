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
     * 递归反转链表空间复杂度O(n) 因为递归会占用栈空间, leetcode:206
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
     * leetcode 官方解法,题号：141
     * public boolean hasCycle(ListNode head) {
     * if (head == null || head.next == null) {
     * return false;
     * }
     * ListNode slow = head;
     * ListNode fast = head.next;
     * while (slow != fast) {
     * if (fast == null || fast.next == null) {
     * return false;
     * }
     * slow = slow.next;
     * fast = fast.next.next;
     * }
     * return true;
     * }
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

    /**
     * 合并两个有序链表 leetcode：21
     * @param list1
     * @param list2
     * @return
     */
    public SingleLinkedList<Integer> merge(SingleLinkedList<Integer> list1, SingleLinkedList<Integer> list2) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.head = merge(list1.head, list2.head);
        return list;
    }

    private Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {

        Node<Integer> newHead = new Node<>();

        Node<Integer> newNode = newHead;

        while (l1 != null && l2 != null) {
            if (l1.data >= l2.data) {
                newNode.next = l2;
                l2 = l2.next;
            } else {
                newNode.next = l1;
                l1 = l1.next;
            }
            newNode = newNode.next;
        }

        newNode.next = l1 == null ? l2 : l1;

        return newHead.next;
    }

    /**
     * 删除倒数指定位数的节点
     * @param index leetcode: 19
     * @return
     */
    public T removeTailByIndex(int index) {
        Node<T> dummyNode = new Node<>(null, head);

        Node<T> fastPointer = dummyNode;
        Node<T> slowPointer = dummyNode;

        // 先将快指针移动 index + 1个节点
        int count = -1;
        while (count < index) {
            fastPointer = fastPointer.next;
            count++;
        }

        // 同时移动快慢指针，直到快指针到链表尾部，此时慢指针正好处于要删除节点的上一个节点
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        Node<T> result = slowPointer.next;

        slowPointer.next = slowPointer.next.next;

        this.head = dummyNode.next;

        return result.data;
    }

    /**
     * 返回链表中间节点
     * @return
     */
    public T midData(){
        Node<T> fastPointer = head;
        Node<T> slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
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
