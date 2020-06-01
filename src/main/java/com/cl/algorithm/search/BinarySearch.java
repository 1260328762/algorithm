package com.cl.algorithm.search;

/**
 * @author chenliang
 * @date 2020-05-29
 * 二分查找法
 */
public class BinarySearch {

    /**
     * 普通二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 性能优化到极致
            // int mid = low + (high - low) >> 1
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int recursionSearch(int[] arr, int target) {
        return recursion(arr, 0, arr.length - 1, target);
    }

    private static int recursion(int[] arr, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + ((end - start) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recursion(arr, start, mid - 1, target);
        }
        return recursion(arr, mid + 1, end, target);
    }

    /**
     * 二分查找：查找数组中第一次出现的值
     *
     * @return
     */
    public static int searchFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 性能优化到极致
            // int mid = low + (high - low) >> 1
            if (arr[mid] == target) {
                if (mid != 0) {
                    while (arr[--mid] == target) {
                        if (mid == 0) return 0;
                    }
                    return mid + 1;
                }
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找：查找数组中最后一次出现的值
     *
     * @return
     */
    public static int searchLast(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 性能优化到极致
            // int mid = low + (high - low) >> 1
            if (arr[mid] == target) {
                if (mid != arr.length - 1) {
                    while (arr[++mid] == target) {
                        if (mid == arr.length - 1)
                            return mid;
                    }
                    return mid - 1;
                }
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找：查找数组中第一个大于给定值的下标
     *
     * @return
     */
    public static int searchFirstGreater(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target)
                    return mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找：查找数组中最后一个小于给定值的下标
     *
     * @return
     */
    public static int searchFirstLess(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] > target)
                    return mid;
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 在循环有序数组中利用二分查找查找指定元素
     * leetcode: 33
     * @return
     */
    public static int cycleOrderSearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] ==  target) return mid;
            if (start == end) break;

            // 判断两边数组哪个是有序数组
            if (arr[start] <= arr[mid]) {
                // 左边有序
                if (arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 右边有序
                if (arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
