package com.cl.question.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/8 21:29
 * <p>
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatNumber {

    /**
     * hash表解法
     */
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i : nums) {
            int value = hashMap.getOrDefault(i, 0);
            if (value > 0) return i;

            hashMap.put(i, value + 1);
        }

        return -1;
    }

    /**
     * 排序比较
     */
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }
}
