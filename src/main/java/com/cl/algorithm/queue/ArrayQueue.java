package com.cl.algorithm.queue;

/**
 * @author chenliang
 * @date 2020-05-19
 */
public class ArrayQueue<T> {
    private Object[] items;

    private int size;

    private int head;

    private int tail;

    public ArrayQueue(int capacity){
        items = new Object[capacity];
        size = 0;
    }

    public boolean push(T data) {
        if (items.length == size)
            return false;
        if (tail == items.length) {
            if (head == 0)
                return false;
            System.arraycopy(items, head, items, 0, tail = tail - head);
            head = 0;
        }
        items[tail++] = data;
        size++;
        return true;
    }


    public T pop(){
        if (isEmpty())
            return null;
        T item = peek();
        size--;
        head++;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) items[head];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + "->");
        }
    }
}
