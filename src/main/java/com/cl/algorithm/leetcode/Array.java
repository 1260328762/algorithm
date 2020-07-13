package com.cl.algorithm.leetcode;

/**
 * @author chenliang
 * @date 2020-07-13
 * array相关练习题
 */
public class Array {


    /**
     * 两个有序数组合并为一个有序数组
     * leetcode: 88
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
}
