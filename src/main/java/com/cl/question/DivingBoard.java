package com.cl.question;

import java.util.Arrays;

/**
 * @author chenliang
 * @since 2021/12/13 17:47
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k + 1];
        int shortCount = k;
        int longerCount = 0;

        int index = 0;
        while (shortCount >= 0) {
            int value = shortCount * shorter + longerCount * longer;
            int i = index == 0 ? 0 : index - 1;
            if (result[i] != value) {
                result[index++] = value;
            }
            shortCount--;
            longerCount++;
        }
        int[] finalResult = new int[index];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    }

    public static void main(String[] args) {
        int[] ints = new DivingBoard().divingBoard(1, 1, 2);
        System.out.println(Arrays.toString(ints));
    }
}
