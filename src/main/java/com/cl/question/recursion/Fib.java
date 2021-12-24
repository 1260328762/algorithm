package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/23 10:05
 * <p>
 * 剑指 Offer 10- I. 斐波那契数列
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fib {

    /**
     * for循环方式
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int pp = 0;
        int p = 1;
        while (n >= 2) {
            int result = pp % 1000000007 + p % 1000000007;
            pp = p;
            p = result;
            n--;
        }

        return p % 1000000007;
    }

    /**
     * 递归方式
     */
    public int fib2(int n) {
        int[] cache = new int[n + 1];
        return f(n, cache);
    }

    private int f(int n, int[] cache) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache[n] != 0) {
            return cache[n];
        }
        return cache[n] = (f(n - 1, cache) + f(n - 2, cache)) % 1000000007;
    }
}
