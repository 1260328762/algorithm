package com.cl.question.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/8 19:55
 * <p>
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 其他解法：构建一个容量为26的数组，索引0存a出现的个数 索引25存放z出现的个数，
 */
public class IsAnagram {

    /**
     * hash表解法，时间复杂度O(n)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (hashMap.getOrDefault(c, 0) == 0) return false;
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
        }

        return true;
    }

    /**
     * 先排序后比较，时间复杂度O(nlogn) ---> 排序复杂度 O(nlogn), 比较O(n)
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


}
