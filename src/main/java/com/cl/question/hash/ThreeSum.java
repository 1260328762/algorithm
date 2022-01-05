package com.cl.question.hash;

import java.util.*;

/**
 * @author chenliang
 * @since 2022/1/5 14:33
 * <p>
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    /**
     * 排序 + hash表
     * 排序为了去除重复的组合
     * hash表为了降低时间复杂度
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复元素a
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // 跳过重复元素b
                if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                // a + b + c = 0 --> -(a + b) = c
                int twoSum = -(nums[i] + nums[j]);
                if (hashMap.containsKey(twoSum)) {
                    int index = hashMap.get(twoSum);
                    // 当符合条件的数值索引要在a b两数索引之后才添加到集合中
                    if (index > i && index > j) {
                        result.add(Arrays.asList(nums[i], nums[j], twoSum));
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
