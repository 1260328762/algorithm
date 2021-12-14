package com.cl.question.stack;

import java.util.LinkedList;

/**
 * @author chenliang
 * @since 2021/12/14 21:13
 * <p>
 * 225. 用队列实现栈
 * <p>
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {

    private final LinkedList<Integer> linkedList = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        linkedList.push(x);
    }

    public int pop() {
        return linkedList.removeFirst();
    }

    public int top() {
        return linkedList.peekFirst();
    }

    public boolean empty() {
        return linkedList.isEmpty();
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

    }
}


