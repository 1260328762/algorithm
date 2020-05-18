package com.cl.algorithm.stack;

import java.util.NoSuchElementException;

/**
 * @author chenliang
 * @date 2020-05-18
 */
public class ArrayStack<T> {

    private int size;

    private Object[] items;

    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        size = 0;
        items = new Object[capacity];
    }

    public boolean push(T data) {
        if (size == capacity) return false;

        items[size] = data;
        size++;
        return true;
    }


    public T pop() {
        T peek = peek();
        size--;
        return peek;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if (size == 0)
            return null;

        Object item = items[size - 1];
        return (T)item;
    }

}
