package com.cl.question.bsearch;

/**
 * @author chenliang
 * @since 2021/12/29 20:57
 * <p>
 * 744. 寻找比目标字母大的最小字母
 * <p>
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] > target) {
                // 如果mid == 0，说明mid位置的元素就是比target大的最小元素
                // 如果mid - 1位置的元素小于等于mid位置的元素，mid位置元素就是比target大的最小元素
                if (mid == 0 || letters[mid - 1] <= target) {
                    return letters[mid];
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return letters[0];
    }

    public static void main(String[] args) {
        char j = new NextGreatestLetter().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j');
        System.out.println(j);
    }
}
