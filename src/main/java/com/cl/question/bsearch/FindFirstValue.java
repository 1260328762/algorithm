package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/29 10:13
 * 在数组中查找第一个和给定元素值相等的下标
 */
public class FindFirstValue {

    /**
     *  解题思路：先二分，再使用左探测法确定第一个元素
     */
    public int findFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                // 左探测确定当前值是否是第一个
                if (mid == 0 || arr[mid - 1] != target)
                    return mid;
                else
                    low = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int first = new FindFirstValue().findFirst(new int[]{1, 2, 3, 4, 4, 4, 5, 6}, 6);
        System.out.println(first);
    }
}
