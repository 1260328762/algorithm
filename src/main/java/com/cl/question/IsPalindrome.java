package com.cl.question;

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

    /**
     * 标准双指针解法
     */
    public boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (shouldSkip(s.charAt(start))) {
                start++;
                continue;
            }
            if (shouldSkip(s.charAt(end))) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean shouldSkip(char aChar) {
        return !((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z')
                || (aChar >= 'A' && aChar <= 'Z'));
    }

    public static void main(String[] args) {
        boolean palindrome = new IsPalindrome().isPalindrome2("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
