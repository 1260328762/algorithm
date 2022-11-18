package com.cl.ipc;

import java.util.TreeMap;

/**
 * @author chenliang
 * @since 2022/9/19 22:35
 * 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/shu-ju-liu-zhong-de-zhong-wei-shu-by-lee-um4f/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MedianFinder {

    TreeMap<Double, Double> nums;
    int n;
    double[] left;
    double[] right;

    public MedianFinder() {
        nums = new TreeMap<Double, Double>();
        n = 0;
        left = new double[2];
        right = new double[2];
    }

    public void addNum(double num) {
        nums.put(num, nums.getOrDefault(num, 0D) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
        } else {
            if (num > left[0] && num < right[0]) {
                increase(left);
                decrease(right);
            } else if (num >= right[0]) {
                increase(left);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }

    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }

    private void increase(double[] iterator) {
        iterator[1]++;
        if (iterator[1] > nums.get(iterator[0])) {
            iterator[0] = nums.ceilingKey(iterator[0] + 1);
            iterator[1] = 1;
        }
    }

    private void decrease(double[] iterator) {
        iterator[1]--;
        if (iterator[1] == 0) {
            iterator[0] = nums.floorKey(iterator[0] - 1);
            iterator[1] = nums.get(iterator[0]);
        }
    }
}
