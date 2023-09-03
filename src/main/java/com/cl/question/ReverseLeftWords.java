package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/3 21:01
 * <p>
 * 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * TODO 解法2：降低空间复杂度，1.开辟一个n长度的数组，在原数组上移动，然后将新数组元素复制到最后 2.开辟一个1长度的数组，每次存储一个数字，并且原数组整体每次往前移动一次
 */
public class ReverseLeftWords {


    /**
     * 开辟一个新数组，先把n后面的元素复制到数组中，在把n前面的元素复制到数组中，空间复杂度O(n)
     */
    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }
        char[] chars = new char[s.length()];

        int size = 0;
        for (int i = n; i < s.length(); i++) {
            chars[size++] = s.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            chars[size++] = s.charAt(i);
        }

        return new String(chars);
    }

    /**
     * 直接采用JDK自带方法 一步到位
     */
    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }


    public static void main(String[] args) {
        String result = new ReverseLeftWords().reverseLeftWords("abcdefg", 2);
        System.out.println(result);
    }
}
