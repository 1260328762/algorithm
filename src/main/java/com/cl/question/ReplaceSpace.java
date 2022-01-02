package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/2 21:52
 * <p>
 * 剑指 Offer 05. 替换空格
 * <p>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                // 查找到空格直接插入固定字符串进去
                builder.append("%20");
            } else {
                builder.append(ch);
            }
        }


        return builder.toString();
    }

    public static void main(String[] args) {
        String s = new ReplaceSpace().replaceSpace("We are happy.");
        System.out.println(s);
    }
}
