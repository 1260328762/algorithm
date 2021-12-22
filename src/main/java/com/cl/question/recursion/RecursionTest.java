package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/21 16:03
 */
public class RecursionTest {

    public int f(int n) {
        if (n == 1) return 1;
        return f(n - 1) + 3;
    }


    public static void main(String[] args) {
        RecursionTest recursionTest = new RecursionTest();
        System.out.println(recursionTest.f(4));
    }
}
