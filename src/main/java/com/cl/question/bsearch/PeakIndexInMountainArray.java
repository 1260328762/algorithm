package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/31 14:43
 * <p>
 * 852. 山脉数组的峰顶索引
 * <p>
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i< arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0) {
                // mid = 0，说明峰值节点在右边
                low = mid + 1;
            } else if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                // 左右探测，如果左右两侧值都小于mid值，说明mid是峰值索引
                return mid;
            } else if (arr[mid + 1] < arr[mid]) {
                // 如果右边比mid大，说明峰值节点在左侧区间
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
