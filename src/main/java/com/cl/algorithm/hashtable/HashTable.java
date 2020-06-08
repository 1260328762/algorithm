package com.cl.algorithm.hashtable;

/**
 * @author chenliang
 * @date 2020-06-01
 * 散列表
 */
public class HashTable<K, V> {

    private int size;

    private int capacity;

    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    /**
     * 存放数组的数组
     */
    private Entry<K, V>[] table;

    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_INITIAL_CAPACITY];
    }


    public void put(K key, V value) {
        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (entry == null || entry.key.equals(key)) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> next = entry.next;
            if (next == null) {
                entry.next = newEntry;
            } else {
                while (next.next != null) {
                    next = next.next;
                }
                next.next = newEntry;
            }
        }
        size++;
    }

    public V get(K key) {
        Entry<K, V> entry = table[hash(key)];
        if (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            while (entry.next != null) {
                entry = entry.next;
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        if (entry != null) {
            if (entry.key.equals(key)) {
                table[index] = table[index].next;
            } else {
                Entry<K, V> preEntry = findPreEntry(entry, key);
                preEntry.next.next = preEntry.next.next.next;
            }
            size--;
        }
    }

    private Entry<K, V> findPreEntry(Entry<K, V> head, K key){
        Entry<K, V> curr = new Entry<>(head);
        while (curr.next != null) {
            if (key.equals(curr.next.key)) {
                break;
            }
            curr = curr.next;
        }
        return new Entry<>(curr);
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & table.length - 1;
    }


    private static class Entry<K, V> {
        private K key;
        private V value;

        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(Entry<K, V> next) {
            this.next = next;
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
