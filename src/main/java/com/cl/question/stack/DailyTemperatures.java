package com.cl.question.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenliang
 * @since 2021/12/18 21:38
 * <p>
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * TODO 单调栈
 */
public class DailyTemperatures {

    /**
     * 暴力解法
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int days = 0;
            int k = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                k++;
                if (temperatures[j] > temperatures[i]) {
                    days = k;
                    break;
                }
            }
            result[i] = days;
        }

        return result;
    }

    /**
     * 单调栈解法
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

}
