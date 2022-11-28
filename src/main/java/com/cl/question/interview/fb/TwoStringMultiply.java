package com.cl.question.interview.fb;

/**
 * @author chenliang
 * @since 2022/11/23 10:07
 */
public class TwoStringMultiply {

    /**
     * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
     * 不能用Java内置函数和数字处理库
     */
    public String multiply(String num1, String num2) {
        int n1 = toInt(num1);
        int n2 = toInt(num2);
        return n1 * n2 + "";
    }

    public int toInt(String num) {
        int n1 = 0;
        boolean isPositive = num.charAt(0) != '-';
        char[] chars = num.toCharArray();
        for (char aChar : chars) {
            if (aChar == '-' || aChar == '+') continue;
            n1 = n1 * 10 + (aChar - '0');
        }
        return isPositive ? n1 : -n1;
    }
}
