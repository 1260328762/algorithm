package com.cl.question.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/9 12:16
 * <p>
 * 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    /**
     * hash表 + 排序
     * 解题思路：遍历字符串数组，将每个字符串进行排序，排序后的字符串作为key，value存放所有排序后等于key的原字符串
     * 时间复杂度0(nklogk) n是字符串数量，k为单个字符串最大长度，字符串排序时间复杂度为O(klogk)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newKey = new String(chars);
            List<String> value = hashMap.getOrDefault(newKey, new ArrayList<>());
            value.add(str);
            hashMap.put(newKey, value);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) throws Exception {
        // InputStream stream = GroupAnagrams.class.getClassLoader()
        //         .getResourceAsStream("hash/GroupAnagramsTestCase.json");
        // byte[] bytes = new byte[stream.available()];
        // stream.read(bytes);
        // String[] strings = JsonUtils.toBean(new String(bytes), String[].class);
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
