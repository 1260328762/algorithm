package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/31 11:02
 */
public class FindMin {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low == high) {
                return nums[low];
            } else if (mid == 0) {
                if (nums[mid + 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    mid = low + 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
                    return nums[mid];
                } else if (nums[low] > nums[mid]) {
                    // 左边无序，在左边搜索
                    high = mid - 1;
                } else if (nums[high] < nums[mid]) {
                    // 右边无序，在右边搜索
                    low = mid + 1;
                } else {
                    // 左右都有序，返回最左侧元素
                    return nums[mid];
                }
            }
        }

        return -1;
    }
}
