package com.cl.question.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/5 14:33
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int twoSum = -(nums[i] + nums[j]);
                if (map.containsKey(twoSum)) {
                    int index = map.get(twoSum);
                    if (index != i && index != j) {
                        result.add(Arrays.asList(nums[i], nums[j], twoSum));
                    }
                }
            }
        }

        return result;
    }
}
