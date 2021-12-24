package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/23 13:52
 * <p>
 * 面试题 08.01. 三步问题
 * <p>
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * 示例2:
 * <p>
 * 输入：n = 5
 * 输出：13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WaysToStep {

    public int waysToStep(int n) {
        int[] cache = new int[n + 1];
        return f(n, cache);
    }

    public int f(int n, int[] cache) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (cache[n] != 0) return cache[n];
        return cache[n] = ((f(n - 1, cache) + f(n - 2, cache)) % 1000000007
                + f(n - 3, cache)) % 1000000007;
    }
}
