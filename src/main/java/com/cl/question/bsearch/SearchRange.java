package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/30 17:19
 * <p>
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, target, true);
        int last = search(nums, target, false);

        return new int[]{first, last};
    }

    public int search(int[] nums, int target, boolean first) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                if (first) {
                    // 左探测
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    // 右探测
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        // 最后一次出现
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
