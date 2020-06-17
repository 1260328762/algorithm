package com.cl.algorithm.heap;

import java.util.NoSuchElementException;

/**
 * @author chenliang
 * @date 2020-06-11
 * 数组实现堆结构
 */
public class ArrayHeap {

    private int[] items;

    private int size;

    /**
     * 0 - 表示大顶堆 1 - 表示小顶堆
     */
    private int type;

    public ArrayHeap(int capacity, int type) {
        items = new int[capacity + 1];
        this.type = type;
    }

    public void add(int data) {
        ensureCapacity();
        items[++size] = data;
        heapifyUp();
    }

    /**
     * 弹出头元素
     * @return
     */
    public int popHead() {
        if (size <= 0) {
            throw new NoSuchElementException();
        }
        int head = items[1];
        heapifyDown();
        return head;
    }

    public int head(){
        return items[1];
    }

    public int size(){
        return size;
    }

    /**
     * 从下向上堆化
     */
    private void heapifyUp() {
        int i = size;
        while (i / 2 != 0 && ((type == 0 && items[i] > items[i / 2])
                || (type == 1 && items[i] < items[i / 2]))) {
            swap(i, i = i / 2);
        }
    }

    /**
     * 从上往下堆化
     */
    private void heapifyDown(){
        items[1] = items[size];
        items[size--] = 0;
        int i = 1;
        while (true) {
            int targetIndex = i;
            if (i * 2 <= size && ((type == 0 && items[i] < items[i * 2])
                    || (type == 1 && items[i] > items[i * 2]))) {
                targetIndex = i * 2;
            }
            if (i * 2 + 1 <= size && ((type == 0 && items[targetIndex] < items[i * 2 + 1])
                    || (type == 1 && items[targetIndex] > items[i * 2 + 1]))) {
                targetIndex = i * 2 + 1;
            }
            if (i == targetIndex) break;
            swap(i, targetIndex);
            i = targetIndex;
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
