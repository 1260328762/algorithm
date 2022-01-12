package com.cl.question.hash;

import java.util.HashSet;

/**
 * @author chenliang
 * @since 2022/1/11 9:33
 * <p>
 * 面试题 16.21. 交换和
 * <p>
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 * <p>
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 * <p>
 * 示例:
 * <p>
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSwapValues {

    /**
     * 解题思路：分别计算两个数组的和，然后计算当两个数组和相等时，那么和应该是多少((sum1 + sum2) / 2)，
     * 假设和为s, 计算arr1和s的差值diff，那么arr1中任意一个元素加上diff都等于s,此时遍历arr1，然后判断arr2包不包含(arr[i] + diff)的差值即可
     */
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        for (int i : array1) {
            sum1 += i;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        int sum2 = 0;
        for (int i : array2) {
            sum2 += i;
            hashSet.add(i);
        }

        int sum = sum1 + sum2;
        // 如果两数组和为奇数，则无解
        if (sum % 2 != 0) return new int[0];

        int diff = sum / 2 - sum1;
        for (int i : array1) {
            int target = i + diff;
            if (hashSet.contains(target)) {
                return new int[]{i, target};
            }
        }

        return new int[0];
    }
}
