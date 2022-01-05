package com.cl.question.hash;

import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/5 10:28
 * @see com.cl.question.TwoSum
 *  两数之和hash表解法
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                // 判断当前下表是否和hash表中下表相等，如果相等说明是同一个元素
                int index = map.get(key);
                if (index != i) {
                    return new int[]{i, index};
                }
            }
        }

        return new int[0];
    }
}
