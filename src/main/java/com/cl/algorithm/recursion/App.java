package com.cl.algorithm.recursion;

/**
 * @author chenliang
 * @since  2020-05-20
 * leetcode 递归相关题目
 */
public class App {
    public static void main(String[] args) {
        System.out.println(climbStairs(450));
    }

    public static int f(int n) {
        if (n == 1) return 1;
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
        return f(n - 1) + 1;
    }


    /**
     * 走台阶问题，假设有n个台阶，一次可以走一步，也可以走两步，
     * 那走完n级台阶可以有多少种解法
     * @param n
     * @return
     */
    public static int footStep(int n){

        if (n == 1) return 1;
        if (n == 2) return 2;
        return footStep(n - 1) + footStep(n - 2);
    }

    /**
     * 使用记忆法优化，走台阶问题
     * leetcode: 70
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] container = new int[n + 1];
        return doClimbStairs(n, container);
    }

    public static int doClimbStairs(int n, int[] temp) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (temp[n] > 0) {
            return temp[n];
        }
        return temp[n] = doClimbStairs(n - 1, temp) + doClimbStairs(n - 2, temp);
    }

    /**
     * 非递归实现爬楼梯
     * @param n
     * @return
     */
    public static int climbStairs2(int n){
        if (n == 1) return 1;
        if (n == 2) return 2;

        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

}
