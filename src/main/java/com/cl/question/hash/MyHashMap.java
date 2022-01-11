package com.cl.question.hash;


import java.util.LinkedList;

/**
 * @author chenliang
 * @since 2022/1/10 21:24
 * <p>
 * 706. 设计哈希映射
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashMap {

    private final LinkedList<Pair>[] hashtable;
    int capacity = 5000;

    public MyHashMap() {
        hashtable = new LinkedList[capacity];
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Pair> linkedList = hashtable[index];
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }


        boolean isFind = false;
        for (Pair pair : linkedList) {
            if (pair.key == key) {
                pair.value = value;
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            linkedList.add(new Pair(key, value));
        }

        hashtable[index] = linkedList;
    }

    public int get(int key) {
        LinkedList<Pair> linkedLists = hashtable[hash(key)];
        if (linkedLists == null) return -1;
        for (Pair pair : linkedLists) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> linkedList = hashtable[index];
        if (linkedList != null) {
            Pair pair = null;
            for (Pair temp : linkedList) {
                if (temp.key == key) {
                    pair = temp;
                    break;
                }
            }

            if (pair != null) {
                linkedList.remove(pair);
            }
        }

    }

    private int hash(int key) {
        return key % capacity;
    }

    private static class Pair {
        private int key;
        private int value;

        public Pair() {
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1, 2);
        hashMap.put(1, 3);

        System.out.println(hashMap.get(1));

        hashMap.remove(1);
        System.out.println(hashMap.get(1));
    }
}
