package com.cl.question.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/9 12:16
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();

        while (strs.length > 0) {
            List<String> temp = new ArrayList<>();

            List<String> candi = new ArrayList<>();
            char[] first = strs[0].toCharArray();
            Arrays.sort(first);
            candi.add(strs[0]);

            for (int i = 1; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                boolean equals = Arrays.equals(first, chars);
                if (equals) {
                    candi.add(strs[i]);
                } else {
                    temp.add(strs[i]);
                }
            }

            results.add(candi);
            strs = temp.toArray(new String[0]);
        }

        return results;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
