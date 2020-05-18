package com.cl.algorithm.stack;

/**
 * @author chenliang
 * @date 2020-05-18
 * 设计一个能在常数时间内检索出一个最小元素的栈
 * leetcode: 155
 */
public class MinStack {

    private ArrayStack<Integer> stack = new ArrayStack<>(100);

    /**
     * 存放最小元素的栈
     */
    private ArrayStack<Integer> minStack = new ArrayStack<>(100);


    public void push(int data) {
        stack.push(data);

        Integer peek = minStack.peek();

        if (peek != null && peek < data) {
            minStack.push(peek);
        } else {
            minStack.push(data);
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

}
