package com.cl.question;

import java.util.Arrays;

/**
 * @author chenliang
 * @since 2021/12/1 14:02
 * <p>
 * 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * <p>
 * 示例
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * TODO 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length -1; i++) {
            int first = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (first + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 26);
        System.out.println(Arrays.toString(ints));
    }
}
