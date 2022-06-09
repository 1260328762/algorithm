package com.cl.question.btree;

/**
 * @author chenliang
 * @since 2022/3/14 21:39
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class VerifyPostorder {

    /**
     * 解题思路：第一步确定左右子树在数组中的位置，第二步判断根节点大小是否符合二叉搜索树的定义
     */
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean verify(int[] postorder, int start, int end, long low, long high) {
        if (start > end) return true;
        int root = postorder[end];
        if (root < low || root > high) return false;
        int rightCount = 0;
        for (int i = end - 1; i >= start; i--) {
            if (postorder[i] > root) {
                rightCount++;
            } else {
                break;
            }
        }

        return verify(postorder, end - rightCount, end - 1, root, high)
                && verify(postorder, start, end - rightCount - 1, low, root);
    }

    public static void main(String[] args) {
        boolean verifyPostorder = new VerifyPostorder().verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10});
        System.out.println(verifyPostorder);
    }
}
