package com.cl.algorithm.stack;

/**
 * @author chenliang
 * @date 2020-05-18
 * 使用栈来实现一个微型计算器
 */
public class Calculator {

    /**
     * 保存操作数的栈
     */
    private ArrayStack<Integer> operandStack = new ArrayStack<>(100);

    /**
     * 保存操作符的栈
     */
    private ArrayStack<Character> operatorStack = new ArrayStack<>(100);



    public int calculate(String express) {
        char[] chars = express.toCharArray();
        for (char c : chars) {
            if (isNumber(c)) {
                operandStack.push(Integer.valueOf(String.valueOf(c)));
            } else if (isOperator(c)) {
                Character operator = operatorStack.peek();

                if (operator != null) {

                    int prePriority = getPriority(operator);

                    int curPriority = getPriority(c);

                    while (operator != null && prePriority <= curPriority) {
                        Integer pop1 = operandStack.pop();
                        Integer pop2 = operandStack.pop();
                        int result = calculate(pop1, pop2, operator);
                        operandStack.push(result);
                        operatorStack.pop();

                        operator = operatorStack.peek();
                        if (operator != null) {
                            prePriority = getPriority(operator);

                            curPriority = getPriority(c);
                        }
                    }
                }

                operatorStack.push(c);
            } else {
                throw new IllegalArgumentException(String.valueOf(c));
            }
        }

        Integer pop1 = operandStack.pop();
        Integer pop2 = operandStack.pop();

        while (pop2 != null) {
            operandStack.push(calculate(pop1, pop2, operatorStack.pop()));
            pop1 = operandStack.pop();
            pop2 = operandStack.pop();
        }
        return pop1;
    }

    private int calculate(int op1, int op2, char operator) {
        if ('+' == operator) {
            return op2 + op1;
        } else if ('-' == operator) {
            return op2 - op1;
        } else if ('*' == operator) {
            return op2 * op1;
        } else {
            return op2 / op1;
        }
    }

    public boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c =='/';
    }

    public boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    public int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 1;
        }
        return 0;
    }
}
