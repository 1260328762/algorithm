package com.cl.question.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/8 21:43
 * <p>
 * 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {

    /**
     * 排序+前后探测，时间复杂度O(nlogn)
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if (nums.length == 1 || nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return nums[i];
        }

        return -1;
    }

    /**
     * hash表
     */
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        for (int i : nums) {
            if (hashMap.get(i) == 1) return i;
        }

        return -1;
    }
}
