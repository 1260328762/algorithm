package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/31 9:40
 * 33. 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，
 * 则返回它的下标，否则返回-1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchCircleArray {

    /**
     * 解题思路: 利用二分将数组一分为二，当mid节点不等于target时，
     * 判断左右两区间哪个区间时有序区间，并且判断target是否落在有序区间内，
     * 如果落在有序区间内，在在此区间内再次进行二分，反之在另一个区间
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[low] <= nums[mid]) {
                    // 如果左区间有序递增，并且target在此范围中，则在左区间查询
                    if (nums[low] <= target && target < nums[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                } else {
                    // 如果右区间有序递增，并且target在此范围中，则在右区间查询
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

}
