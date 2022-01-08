package com.cl.question.hash;

import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/8 19:44
 * <p>
 * 面试题 01.02. 判定是否互为字符重排
 * <p>
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPermutation {

    /**
     * hash表算法，value存储每个字符出现的次数
     */
    public boolean checkPermutation(String s1, String s2) {
        HashMap<Character, Integer> hashMap = new HashMap<>(s1.length());
        for (char c : s1.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (hashMap.getOrDefault(c, 0) == 0) return false;
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
        }

        return true;
    }
}
