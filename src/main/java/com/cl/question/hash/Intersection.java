package com.cl.question.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/9 10:39
 * <p>
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection {

    /**
     * hash表解法
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>(nums1.length);
        for (int i : nums1) {
            hashSet.add(i);
        }

        for (int i : nums2) {
            if (hashSet.contains(i)) {
                hashSet.remove(i);
                results.add(i);
            }
        }

        int[] arr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            arr[i] = results.get(i);
        }
        return arr;
    }
}
