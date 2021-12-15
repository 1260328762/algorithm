package com.cl.question.stack;

/**
 * @author chenliang
 * @since 2021/12/15 21:52
 */
public class Calculater {

    public int calculate(String s) {

    }


    private int call(int first, int second, char oper) {
        switch(oper){
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/': return first / second;
        }
    }
}
