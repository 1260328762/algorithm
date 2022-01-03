package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2022/1/2 19:48
 * <p>
 * 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断m * n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix {

    /**
     * 解体思路，二维转一维
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix[0].length;
        int high = matrix.length * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // 计算第一层数组索引;
            int f = mid / m;
            // 计算第二层数组索引
            int s = mid % m;
            int value = matrix[f][s];
            if (value == target) {
                return true;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
