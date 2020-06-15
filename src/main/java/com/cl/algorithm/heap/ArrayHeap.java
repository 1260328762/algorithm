package com.cl.algorithm.heap;

/**
 * @author chenliang
 * @date 2020-06-11
 * 数组实现堆结构
 */
public class ArrayHeap {

    private int[] items;

    private int size;

    public ArrayHeap(int capacity) {
        items = new int[capacity + 1];
    }

    public void add(int data) {
        ensureCapacity();
        items[++size] = data;

        int i = size;
        while (i / 2 != 0 && items[i] > items[i / 2]) {
            swap(i, i = i / 2);
        }
    }

    public void removeHead() {
        items[1] = items[size];
        items[size] = 0;

        int i = 1;
        if (items[2] > items[3]) {
            while (items[i] < items[i * 2]) {
                swap(i, i = i * 2);
            }
        } else {
            while (items[i] > items[i * 2 + 1]) {
                swap(i, i = i * 2 + 1);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void ensureCapacity() {
    }
}
