package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/31 17:36
 * <p>
 * 162. 寻找峰值
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low == high)
                return mid;
            if (mid == nums.length - 1) {
                return mid;
            } else if (mid == 0) {
                if (nums[mid + 1] > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = high - 1;
                }
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                // 如果mid后面的元素大于mid，说明右侧区间只有两种情况，1，递增，2，存在峰值元素，所以对右侧进行二分，否侧左侧二分
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int peakElement = new FindPeakElement().findPeakElement(new int[]{2, 1});
        System.out.println(peakElement);
    }
}
