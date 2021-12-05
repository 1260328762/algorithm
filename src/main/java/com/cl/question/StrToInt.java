package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/4 18:08
 * <p>
 * 剑指 Offer 67. 把字符串转换成整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrToInt {

    public int strToInt(String str) {
        int first = 0;

        // 找到第一个数字的位置
        while (first < str.length()) {
            char c = str.charAt(first);
            if (isDegit(c) || c == '-' || c == '+') {
                break;
            }

            if (c != ' ') {
                return 0;
            }

            first++;
        }

        // 没有数字，直接返回0
        if (first == str.length()) {
            return 0;
        }

        int second = first + 1;

        while (second < str.length()) {
            if (!isDegit(str.charAt(second))) {
                break;
            }
            second++;
        }

        // 截取出纯数字
        String nums = str.substring(first, second);
        if (nums.equals("-") || nums.equals("+")) {
            return 0;
        }

        return toInt(nums);
    }

    public int toInt(String str) {
        boolean isPositive = str.charAt(0) != '-' || str.charAt(0) == '+';
        int start = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            start = 1;
        }

        int result = 0;
        int limit = Integer.MAX_VALUE / 10;
        for (int i = start; i < str.length(); i++) {
            int temp = str.charAt(i) - '0';
            if (result > limit || result == limit && temp > 7) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
        }
        return isPositive ? result : -result;
    }

    private boolean isDegit(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
        // int i = new StrToInt().strToInt("    0000000000000   ");
        // int i = new StrToInt().strToInt("9223372036854775808");
        // int i = new StrToInt().strToInt("    +0a32");
        // int i = new StrToInt().strToInt("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459");
        // int i = new StrToInt().strToInt("  0000000000012345678");
        // int i = new StrToInt().strToInt("2147483648");
        // int i = new StrToInt().strToInt("  0000000000012345678");
        int i = new StrToInt().strToInt("-91283472332");
        System.out.println(i);

        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE);
    }
}
