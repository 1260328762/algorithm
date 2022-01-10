package com.cl.question.hash;

import java.util.*;

/**
 * @author chenliang
 * @since 2022/1/10 14:11
 * <p>
 * 1122. 数组的相对排序
 * <p>
 * 给你两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RelativeSortArray {

    /**
     * hash表解法
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // 记录arr1中每个元素出现的次数
        for (int i : arr1) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        // 按照arr2中的顺序将元素输入到新数组中
        int[] result = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            int count = countMap.get(i);
            while (count > 0) {
                result[index++] = i;
                count--;
            }
            countMap.remove(i);
        }

        // 将没有出现在arr2中的元素按顺序排序插入到数组最后
        List<Integer> tempSort = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int count = entry.getValue();
            while (count > 0) {
                tempSort.add(entry.getKey());
                count--;
            }
        }

        tempSort.sort(Comparator.naturalOrder());
        for (int i : tempSort) {
            result[index++] = i;
        }

        return result;
    }
}
