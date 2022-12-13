package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/25 19:54
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyPow {

    /**
     * 非递归实现
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long ln = n;
        double res = 1.0;
        if (ln < 0) {
            x = 1 / x;
            ln = -ln;
        }
        while (ln > 0) {
            if ((ln & 1) == 1) res *= x;
            x *= x;
            ln >>= 1;
        }
        return res;
    }

    /**
     * 递归实现
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        boolean re = false;
        if (n < 0) {
            x = 1 / x;
            re = true;
            n = -(n + 1);
        }

        double halfPow = myPow2(x, (n / 2));
        halfPow *= halfPow;
        if (n % 2 != 0) {
            halfPow *= x;
        }

        if (re) {
            return halfPow * x;
        }

        return halfPow;
    }

    public double myPow3(double x, int n) {
        if (n >= 0) return rPow(x, n);
        else return 1 / (rPow(x, -1 * (n + 1)) * x);
    }

    public double rPow(double x, int n) {
        if (n == 0) return 1;
        double halfPow = rPow(x, n / 2);
        if (n % 2 == 1) {
            return halfPow * halfPow * x;
        } else {
            return halfPow * halfPow;
        }
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();

        double v = myPow.myPow2(34.00515, -3);
        System.out.println(v);

    }
}
