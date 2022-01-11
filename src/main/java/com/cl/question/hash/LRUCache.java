package com.cl.question.hash;

import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/11 10:33
 * <p>
 * 146. LRU 缓存
 * <p>
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {

    private int capacity;

    private int size;

    // 利用hashMap支持O(1)级别的查找
    private HashMap<Integer, DNode> hashMap;

    private DNode head = new DNode();
    private DNode tail = new DNode();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>(capacity);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DNode node;
        if (size == 0 || (node = hashMap.get(key)) == null) {
            return -1;
        }

        removeNode(node);
        addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DNode node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addFirst(node);
        } else {
            if (capacity == size) {
                // 达到最大容量，移除链表末尾元素
                hashMap.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }

            DNode newNode = new DNode(key, value);
            addFirst(newNode);
            hashMap.put(key, newNode);
            size++;
        }
    }

    /**
     * 删除链表中的节点
     *
     * @param node 要删除的节点
     */
    private void removeNode(DNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 将新节点插入到链表头部
     *
     * @param node 待插入节点
     */
    private void addFirst(DNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }


    private static class DNode {

        private int key;

        private int value;

        private DNode pre;

        private DNode next;

        public DNode() {
        }

        public DNode(int key, int value, DNode pre, DNode next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }


        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // ["LRUCache","put","put","get","put","put","get"]
        // [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);

        System.out.println(cache.get(2));
        cache.put(1, 1);
        cache.put(4, 1);
    }
}
