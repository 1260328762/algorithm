package com.cl.question.stack;

import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/18 20:20
 * <p>
 * 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < pushed.length; i++) {
            int pushElement = pushed[i];
            int popElement = popped[popIndex];
            if (pushElement == popElement) {
                popIndex++;
                continue;
            }

            if (!stack.isEmpty()) {
                if (popElement == stack.peek()) {
                    stack.pop();
                    popIndex++;
                    while (popIndex < popped.length && !stack.isEmpty()) {
                        if (popped[popIndex++] != stack.peek()) {
                            break;
                        } else {
                            stack.pop();
                        }
                    }

                }
            }
            stack.push(pushElement);

        }

        while (popIndex < popped.length) {
            if (stack.pop() != popped[popIndex++]) {
                return false;
            }
        }


        return true;
    }

    /**
     * 解题思想，遍历数组，依次压栈，每次压栈后判断当前栈顶元素是否和弹栈数组中的元素相同，如果相同就弹栈
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num); // num 入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        boolean b = new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{
                4, 3, 5, 1, 2});
        System.out.println(b);
    }
}
