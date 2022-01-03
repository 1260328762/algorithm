package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2022/1/1 22:10
 * <p>
 * 69. Sqrt(x)
 * <p>
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MySqrt {

    /**
     * 使用二分循环判断，mid平方是否等于x，
     * 如果小于，则探测mid + 1，是否大于x，如果大于，则说明mid是x的平方根。
     *
     * TODO 进阶 -> 要求保留指定小数位：先计算整数，在计算小数位比如整数是，要求保留两位小数，第一步从5.0到5.9选一个，假设是5.3.在从5.30到5.39选一个
     * TODO 获取从5.00到5.99之间进行二分，找到最匹配的一个元素
     */
    public int mySqrt(int x) {
        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = (low + high) / 2;
            long result = (long) mid * mid;
            if (result == x) {
                return mid;
            } else if (result > x) {
                high = mid - 1;
            } else {
                // 右探测
                result = (long) (mid + 1) * (mid + 1);
                if (result <= x) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new MySqrt().mySqrt(6);
        System.out.println(i);
    }
}
