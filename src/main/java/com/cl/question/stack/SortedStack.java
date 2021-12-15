package com.cl.question.stack;

import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/15 11:47
 * <p>
 * 面试题 03.05. 栈排序
 * <p>
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek返回 -1。
 * <p>
 * 示例1:
 * <p>
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-of-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> tempStack = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        while (!stack.isEmpty()) {
            int peek = stack.peek();
            if (val > peek) {
                tempStack.push(stack.pop());
            } else {
                break;
            }
        }

        tempStack.push(val);
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(6);
        sortedStack.push(3);
        sortedStack.push(2);
        sortedStack.push(4);

        System.out.println(sortedStack.peek());
        sortedStack.pop();

        System.out.println(sortedStack.peek());
        sortedStack.pop();

        System.out.println(sortedStack.peek());
        sortedStack.pop();

        System.out.println(sortedStack.peek());
        sortedStack.pop();

    }
}
