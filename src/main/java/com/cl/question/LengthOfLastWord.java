package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/2 21:13
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * <p>
 * s 仅有英文字母和空格 ' ' 组成
 * <p>
 * s 中至少存在一个单词
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        // 双指针
        int first = s.length() - 1;
        // 第一个指针指到不是空格的位置
        while (first > 0 && s.charAt(first) == ' ') {
            first--;
        }

        // 第二个指针指到空格的位置
        int second = first;
        while (second >= 0 && s.charAt(second) != ' ') {
            second--;
        }

        return first - second;
    }

    public static void main(String[] args) {
        int length = new LengthOfLastWord().lengthOfLastWord("    qwe    123123 ");
        System.out.println(length);
    }
}
