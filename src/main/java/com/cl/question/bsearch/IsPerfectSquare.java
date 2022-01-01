package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2022/1/1 21:27
 * <p>
 * 367. 有效的完全平方数
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如sqrt 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare {

    /**
     * 利用二分查找，循环判断mid平方是否等于num
     */
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long result = mid * mid;
            if (result == num) {
                return true;
            } else if (result > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

}
