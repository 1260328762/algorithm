package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/25 19:54
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
