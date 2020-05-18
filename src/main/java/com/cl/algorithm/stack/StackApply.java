package com.cl.algorithm.stack;

import java.util.HashMap;

/**
 * @author chenliang
 * @date 2020-05-18
 * 栈的一些灵活操作 取自leetcode
 */
public class StackApply {

    private static HashMap<Character, Character> bracketMapping;

    public StackApply(){
        bracketMapping = new HashMap<>(3);
        bracketMapping.put(')', '(');
        bracketMapping.put('}', '{');
        bracketMapping.put(']', '[');
    }

    /**
     * 检查字符串中的括号使用是否合法
     * lettcode: 20
     * @param s
     * @return
     */
    public boolean checkBracketsInvalid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>(7010);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isBracket(c)) {
                if (isLeftBracket(c)) {
                    stack.push(c);
                } else {
                    Character pop = stack.pop();
                    if (pop == null || !isPairs(pop, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.pop() == null;
    }

    private boolean isPairs(char left, char right) {
        return left == bracketMapping.get(right);
    }

    private boolean isBracket(char c) {
        return isLeftBracket(c) || isRightBracket(c);
    }

    private boolean isLeftBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isRightBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }


    /**
     * 比较连个字符串是否相同，字符串中的#代表退格键
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * leetcode：844
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        ArrayStack<Character> stack = new ArrayStack<>(401);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        stack.push('-');
        chars = t.toCharArray();
        for (char c : chars) {
            Character peek = stack.peek();
            if (c == '#') {
                if (peek != '-') {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        System.out.println(stack);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        String[] split = builder.toString().split("-");
        return split.length == 2 ? split[0].equals(split[1]) : split.length == 0;
    }

    public boolean leet(String S, String T){
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }

}
