package com.cl.question.stack;

import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/14 20:30
 *
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> tmpStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        int result = tmpStack.isEmpty() ? -1 : tmpStack.pop();

        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

        return result;
    }
}
