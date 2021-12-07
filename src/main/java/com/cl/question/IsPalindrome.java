package com.cl.question;

import com.cl.algorithm.util.SortUtil;

/**
 * @author chenliang
 * @since 2021/12/1 21:30
 * <p>
 * 125. 验证回文串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO 解法2只循环一次，通过双指针不断移动在原字符串上判断
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z')
                    || (aChar >= 'A' && aChar <= 'Z')) {
                sb.append(aChar);
            }
        }

        s = sb.toString().toLowerCase();

        // 双指针验证是否回文
        chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}