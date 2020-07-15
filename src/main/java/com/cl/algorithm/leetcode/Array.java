package com.cl.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenliang
 * @date 2020-07-13
 * array相关练习题
 */
public class Array {


    /**
     * 两个有序数组合并为一个有序数组
     * leetcode: 88
     *
     * @return
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int r = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[r--] = nums1[i--];
            } else {
                nums1[r--] = nums2[j--];
            }
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    /**
     * 三数之和：15
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int k = n - 1;
            int target = -first;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                    count++;
                }

                if (j == k)
                    break;

                if (nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(first, nums[j], nums[k]));
                }
            }
        }

        System.out.println(count);
        return result;
    }


    /**
     * 两数之和：1
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[0];
    }


    /**
     * 求众数：169
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        int maxNumber = 0;
        int maxCount = 0;
        for (int num : nums) {
            Integer count = map.get(num);
            map.put(num, count == null ? count = 1 : ++count);

            if (count > maxCount) {
                maxCount = count;
                maxNumber = num;
            }
        }

        return maxNumber;
    }


    /**
     * 缺失的第一个正数：41
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer, Object> map = new HashMap<>(nums.length);

        int max = -1;
        for (int num : nums) {
            map.put(num, null);

            if (num > max)
                max = num;
        }

        if (max < 1) {
            return 1;
        }

        for (int i = 1; i <= max ; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return max + 1;
    }

}
