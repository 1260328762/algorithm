package com.cl.question.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chenliang
 * @since 2021/12/16 15:35
 */
public class Calculater2 {

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
                    while (!operStack.isEmpty() && operStack.peek() != '(' && compare(c, operStack.peek(), priority)) {
                        calculateAndPush(operStack, numberStack);
                    }
                }
                operStack.push(c);
            } else if (c == '(') {
                operStack.push(c);
            } else if (c == ')') {
                // 开始计算括号内数字
                while (operStack.peek() != '(') {
                    calculateAndPush(operStack, numberStack);
                }
                // 将左括号'('弹栈
                operStack.pop();
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
        // 123
        int calculate = new Calculater2().calculate("1+2 +3*(2/2-1)-2+6*20");
        System.out.println(calculate);
    }
}
