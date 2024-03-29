package com.cl.question.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/15 21:52
 * <p>
 * 面试题 16.26. 计算器
 * <p>
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/calculator-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Calculater {

    public int calculate(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (isDigit(c)) {
                int number = c - '0';
                int j = i + 1;
                while (j < chars.length && isDigit(chars[j])) {
                    number = number * 10 + (chars[j++] - '0');
                    i++;
                }
                numberStack.push(number);
            } else if (isOper(c)) {
                if (!operStack.isEmpty()) {
                    // 判断当前操作符和栈顶操作符的优先级，如果当前操作符优先级小于等于栈顶优先级则先进行栈内元素运算
                    while (!operStack.isEmpty() && compare(c, operStack.peek(), priority)) {
                        calculateAndPush(operStack, numberStack);
                    }
                }
                operStack.push(c);
            }
        }

        while (!operStack.isEmpty()) {
            calculateAndPush(operStack, numberStack);
        }

        return numberStack.pop();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private void calculateAndPush(Stack<Character> operStack, Stack<Integer> numberStack) {
        int second = numberStack.pop();
        numberStack.push(call(numberStack.pop(), second, operStack.pop()));
    }

    private boolean compare(char oper1, char oper2, Map<Character, Integer> priority) {
        return priority.get(oper1) <= priority.get(oper2);
    }

    private boolean isOper(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


    private int call(int first, int second, char oper) {
        switch (oper) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
        }
        return -1;
    }

    public static void main(String[] args) {
        int result = new Calculater().calculate("1+   2 +    3  *   2 / 2-1-2+6*20");
        // int result = new Calculater().calculate("6*20");
        System.out.println(result);
    }
}
