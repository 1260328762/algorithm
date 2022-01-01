package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/30 20:37
 * <p>
 * 面试题 10.05. 稀疏数组搜索
 * <p>
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * <p>
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindString {

    /**
     * 解题思想：首先还是利用二分查找中位数，如果中位数等于空字符串，
     * 则判断low位置元素是否等于目标元素，不等于则将low往前进一位，然后在此基础上在此利用二分。循环往复
     */
    public int findString(String[] words, String s) {
        int low = 0;
        int high = words.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[low].equals(s)) return low;
                else low++;
            } else if (words[mid].compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        int index = new FindString().findString(input, "at");
        System.out.println(index);
    }

}
