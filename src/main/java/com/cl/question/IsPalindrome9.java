package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/1 21:55
 * <p>
 * 9. 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        // 计算整数长度
        int size = 0;
        int value = x;
        while (value != 0) {
            value = value / 10;
            size++;
        }

        // 将整数的每一位分别放入数组
        int[] ints = new int[size];
        int der = 1;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (x / der % 10);

            der = der * 10;
        }

        // 双指针判断是否回文
        for (int i = 0; i < ints.length / 2; i++) {
            if (ints[i] != ints[ints.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new IsPalindrome9().isPalindrome(10022201);
        System.out.println(palindrome);
    }
}
