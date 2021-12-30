package com.cl.question.recursion;

/**
 * @author chenliang
 * @since 2021/12/25 19:29
 * <p>
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 1, B = 10
 * 输出：10
 * 示例2:
 * <p>
 * 输入：A = 3, B = 4
 * 输出：12
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recursive-mulitply-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply {

    public int multiply(int A, int B) {
        if(B == 1) return A;
        int halfValue = multiply(A, B / 2);
        halfValue += halfValue;
        if (B % 2 != 0) {
            halfValue += A;
        }

        return halfValue;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int result = multiply.multiply(4, 9);
        System.out.println(result);
    }

}
