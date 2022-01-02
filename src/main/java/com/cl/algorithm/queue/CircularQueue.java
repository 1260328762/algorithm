package com.cl.algorithm.queue;

/**
 * @author chenliang
 * @since  2020-05-19
 * 循环队列
 */
public class CircularQueue<T> {

    public Object[] items;

    public int size;

    private int head;

    private int tail;

    public CircularQueue(int capacity) {
        items = new Object[capacity];
    }

    public boolean push(T data) {
        if (size == items.length)
            return false;

        items[tail] = data;
        tail = (tail + 1) % items.length;
        size++;
        return true;
    }

    public T pop(){
        if (isEmpty())
            return null;

        T peek = peek();
        head = (head + 1) % items.length;
        size --;
        return peek;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        return (T) items[head];
    }

    public void printAll(){
        while (!isEmpty()) {
            System.out.print(pop() + "->");
        }
    }

}
