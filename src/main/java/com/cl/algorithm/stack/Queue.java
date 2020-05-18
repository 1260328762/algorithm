package com.cl.algorithm.stack;

/**
 * @author chenliang
 * @date 2020-05-18
 * 用栈实现的队列
 * leetcode：232
 */
public class Queue {

    private ArrayStack<Integer> pushStack = new ArrayStack<>(1000);

    private ArrayStack<Integer> popStack = new ArrayStack<>(1000);

    private int head;

    public void push(int data) {
        if (pushStack.isEmpty()) {
            head = data;
        }
        pushStack.push(data);
    }

    public int pop(){
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek(){
        if (!popStack.isEmpty()) {
            return popStack.peek();
        }
        return head;
    }

    public boolean empty(){
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
