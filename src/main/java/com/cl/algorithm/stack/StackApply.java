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

    /**
     * 简单字符计算器 ，支持括号 + -
     * leetcode：224
     * @param s
     * @return
     */
    public int calculate(String s) {
        ArrayStack<Integer> operandStack = new ArrayStack<>(100);

        ArrayStack<Character> operatorStack = new ArrayStack<>(100);

        char[] chars = s.toCharArray();
        boolean preIsNumber = false;
        for (char c : chars) {
            if (c != ' ') {
                if (isNumber(c)) {
                    if (!preIsNumber) {
                        operandStack.push(Integer.valueOf(String.valueOf(c)));
                    } else {
                        Integer pop = operandStack.pop();
                        operandStack.push(Integer.valueOf(String.valueOf(pop).concat(String.valueOf(c))));
                    }
                    preIsNumber = true;
                } else if (isOperator(c)) {
                    Character peek = operatorStack.peek();
                    if (peek != null && isOperator(peek)) {
                        int calculate = calculate(operandStack.pop(), operandStack.pop(), peek);
                        operandStack.push(calculate);
                        operatorStack.pop();
                    }
                    preIsNumber = false;
                    operatorStack.push(c);
                } else if (isLeftBracket(c)) {
                    operatorStack.push(c);
                } else if (isRightBracket(c)) {
                    Character peek = operatorStack.peek();
                    if (isOperator(peek)) {
                        int calculate = calculate(operandStack.pop(), operandStack.pop(), operatorStack.pop());
                        operandStack.push(calculate);
                        operatorStack.pop();
                    } else if (isLeftBracket(peek)) {
                        operatorStack.pop();
                    }
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            Character pop = operatorStack.peek();
            if (isOperator(pop)) {
                return calculate(operandStack.pop(), operandStack.pop(), operatorStack.pop());
            }
            operatorStack.pop();
        }
        return operandStack.pop();
    }

    public boolean isOperator(char c){
        return c == '+' || c == '-';
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }


    private int calculate(int op1, int op2, char operator) {
        if ('+' == operator) {
            return op2 + op1;
        } else if ('-' == operator) {
            return op2 - op1;
        } else {
            throw new IllegalArgumentException(String.valueOf(operator));
        }
    }

    public int calculate2(String s){

        ArrayStack<Integer> stack = new ArrayStack<>(100);
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }

}
