package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/1 20:58
 * <p>
 * 剑指 Offer 58 - I. 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO 双指针法
 */
public class ReverseWords {

    /**
     * 分割 倒序法
     */
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            String item = split[i];
            String trim = item.trim();
            if (!trim.equals("")) {
                sb.append(trim).append(" ");
            }
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        String reverse = new ReverseWords().reverseWords("a good   example");
        System.out.println(reverse);
    }

}
