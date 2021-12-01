package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/1 20:42
 * <p>
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];

            int index = s.length - 1 - i;
            s[i] = s[index];
            s[index] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h','a','n','q','a'};
        new ReverseString().reverseString(chars);
        System.out.println(chars);
    }
}
