package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/31 17:36
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (low == high)
                return low;
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
