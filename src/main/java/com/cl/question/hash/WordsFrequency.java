package com.cl.question.hash;

import java.util.HashMap;

/**
 * @author chenliang
 * @since 2022/1/8 19:47
 * <p>
 * 面试题 16.02. 单词频率
 * <p>
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/words-frequency-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordsFrequency {

    HashMap<String, Integer> map;

    /**
     * hash表算法
     */
    public WordsFrequency(String[] book) {
        map = new HashMap<>(book.length);
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

}
