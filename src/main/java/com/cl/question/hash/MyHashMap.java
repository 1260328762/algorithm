package com.cl.question.hash;


import java.util.LinkedList;

/**
 * @author chenliang
 * @since 2022/1/10 21:24
 */
public class MyHashMap {

    private LinkedList<Pair>[] hashtable;
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
