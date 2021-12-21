package com.cl.question.stack;

import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/18 19:16
 * <p>
 * 1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty()) {
                char peek = stack.peek();
                // 如果栈顶元素和当前字符串一样，则删除栈顶元素
                if (peek == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }

    /**
     * 简化栈
     */
    public String removeDuplicates2(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

    }
}
