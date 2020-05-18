package com.cl.algorithm.stack;

import java.util.HashMap;

/**
 * @author chenliang
 * @date 2020-05-18
 * 栈的一些应用场景 取自leetcode
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
}
